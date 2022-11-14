// Call the dataTables jQuery plugin
$(document).ready(function() {
    //on ready
});

async function newUser(){
  let datos = {};
  datos.nombre = document.getElementById('inputNombre').value;
  datos.apellido = document.getElementById('inputApellido').value;
  datos.email = document.getElementById('inputEmail').value;
  datos.password = document.getElementById('inputPassword').value;
  //datos.telefono = document.getElementById('inputTelefono').value;
  let verificacionPwd = document.getElementById('inputRepeatPassword').value;

  if(verificacionPwd != datos.password){
    alert('las contraseniaas no coinciden!.');
    return;
  }

  const request = await fetch('/api/users', {
  method: 'POST',
  headers: {
      'Accept': 'application/json',
      'Content-Type': 'application/json'
           },
  body: JSON.stringify(datos)
  });
  const usuarios = await request.json();
}