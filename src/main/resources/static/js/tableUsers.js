// Call the dataTables jQuery plugin
$(document).ready(function() {
    loadUsers();
  $('#tableuser').DataTable();
  actualizarEmailUser();
});

function actualizarEmailUser(){
    document.getElementById('txt-email-user').outerHTML = localStorage.email;
}

function getHeaders(){
    return  {
     'Accept': 'application/json',
     'Content-Type': 'application/json',
     'Authorization': localStorage.token
        };
}

async function loadUsers(){
  const request = await fetch('/api/users', {
  method: 'GET',
  headers: getHeaders()
  });
  const usuarios = await request.json();


  let listadoHtml = '';
  for(let usuario of usuarios){
    let btnDelete = '<a href="#" onclick="deleteUser(' +usuario.id+ ')" class="btn btn-danger btn-circle btn-sm"><i class="fas fa-trash"></i></a>' ;
    let telefonotxt = usuario.telefono == null ? '-' : usuario.telefono;
    let usuarioHtml = '<tr><td>'+usuario.id+'</td><td>'+usuario.nombre+' '+usuario.apellido+'</td><td>'+usuario.email+'</td><td>'+telefonotxt+'</td><td>'+btnDelete+'</td></tr>';
    listadoHtml += usuarioHtml;
  }
  console.log(usuarios);
  document.querySelector('#tableuser tbody').outerHTML = listadoHtml;
}

async function deleteUser(id){
  if (!confirm('¿Desea eliminar este usuario?')){
    return;
  }
  const request = await fetch('api/users/'+id, {
  method: 'DELETE',
  headers: getHeaders()
  });
  location.reload();
}