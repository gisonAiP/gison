

$( "#form-login" ).submit(function( event ) {
  event.preventDefault();
  login($("#inputLoginid").val(), $("#inputPassword").val(), function(){
<<<<<<< HEAD
  	window.location.replace('main.html');
=======
  	window.location.replace('note.html');
>>>>>>> 95213e4318eeb60fdcaf378ab749fc097ca07bad
  });
});

