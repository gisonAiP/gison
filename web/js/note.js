var BASE_URI="http://localhost:8081/where";



$("#create_boton").click(function (e) {
    e.preventDefault();
    if ($("#uwaga").val() == "" || $("#lat").val() == "" || $("#lng").val() == "") {
		if ($("#uwaga").val() == "") {
            document.getElementById('uwaga').style.background = '#F6B5B5';
            $('#uwaga').attr('placeholder', 'Podaj treść uwagi!');
        }
        if ($("#lat").val() == "") {
            document.getElementById('lat').style.background = '#F6B5B5';
            $('#lat').attr('placeholder', 'Podaj wsp!');
        }
        if ($("#lng").val() == "") {
            document.getElementById('lng').style.background = '#F6B5B5';
            $('#lng').attr('placeholder', 'Podaj wsp!');
        }
    }else {
        var create = new Object();
		create.name = $('#myselect').change(function() {  //create.name = $('#myselect :selected').val();
        $('#secondSelect').html('');
        jQuery.each($("option:selected",this), function(i, val) {
        $('#secondSelect').append($(val).clone());
        });
		});
	
		
		create.uwaga = $("#uwaga").val();
        create.lat = $("#lat").val();
        create.lng = $("#lng").val();
        CreateRes(create);
    }
});
