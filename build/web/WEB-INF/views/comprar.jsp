<%-- 
    Document   : comprar
    Created on : Dec 6, 2017, 3:19:40 PM
    Author     : admin
--%>


<div class="content movie-selected">
    <div class="item">
        ${transaccion.setIdPelicula(idPelicula)}
        <h4>${Sala1.getPeliculas().get(idPelicula).getNombre()}</h4>
        <img src="img/${Sala1.getPeliculas().get(idPelicula).getNombre()}.jpg">

        <h5>Horario: ${Sala1.getHorarios().get(idPelicula)}</h5>
    </div>

</div>
<div class="container-seats">
    <hr>
    <h4>Selecciona tu asiento</h4>
    <hr>

    <div class="row">
        <i class="fa fa-user-o empty" aria-hidden="true"></i><i class="fa fa-user-o busy" aria-hidden="true"></i><i class="fa fa-user-o empty" aria-hidden="true"></i><i class="fa fa-user-o empty" aria-hidden="true"></i><i class="fa fa-user-o empty" aria-hidden="true"></i>
    </div>
    <div class="row">
        <i class="fa fa-user-o empty" aria-hidden="true"></i><i class="fa fa-user-o empty" aria-hidden="true"></i><i class="fa fa-user-o empty" aria-hidden="true"></i><i class="fa fa-user-o empty" aria-hidden="true"></i><i class="fa fa-user-o empty" aria-hidden="true"></i>
    </div>
    <div class="row">
        <i class="fa fa-user-o busy" aria-hidden="true"></i><i class="fa fa-user-o empty" aria-hidden="true"></i><i class="fa fa-user-o empty" aria-hidden="true"></i><i class="fa fa-user-o empty" aria-hidden="true"></i><i class="fa fa-user-o empty" aria-hidden="true"></i>
    </div>
    <form method="POST" action="confirmacion">
    <input type="submit" value="Comprar" class="btn">
    </form>
</div>
<script>
    $(document).ready(function () {
        $('i').click(function () {
            $(this).toggleClass(function () {
                if ($(this).is('.busy')) {
                    return "empty";
                } else {
                    return "busy";
                }
            });

        });
    });
    $('#compra').click(function(){
        
        $.post("confirmacion").done(function(){
            console.log("g");
        });
    });
</script>