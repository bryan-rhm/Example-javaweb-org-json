

<div class="cartelera-main ">
    <img class="img-responsive" src="http://static.cinepol.is/img/front/8/2017112011293714-prin.jpg">
</div>
<div class="content">
    <c:forEach var="pelicula" items="${peliculas}" varStatus="iter">
        <div class="item">
            <a href='comprar?${iter.index}'><img src="img/${pelicula.getNombre()}.jpg" alt="${pelicula.getNombre()}"></a>
            <div class="item-description">
                <hr>
                <h4>${pelicula.getNombre()}</h4>
                <button class='btn'><a href='https://www.youtube.com/results?search_query=${pelicula.getNombre()}+trailer' target="noopener">Ver Trailer</a></button><br>
                <span class="smallText">Horario ${Sala1.getHorarios().get(iter.index)}</span><br>
                <span>Precio: Q${Sala1.getPrecio()}</span> 
            </div>
            <form action="agregarCarrito" method="post" style="display: none;">
                <input type ="hidden" name="productId" value="${pelicula.getNombre()}">
                <input type="submit" value="Agregar al carrito">
            </form>
        </div>

    </c:forEach>
</div>

<div class="content">
    <h2>Próximamente</h2>
    <c:forEach var="prox" items="${proximamente}" varStatus="iter">
        <div class="item">
            <img src="https://image.tmdb.org/t/p/w300_and_h450_bestv2${prox.get("poster_path")}" >
            <div class="item-description">
                <hr>
                <h4>${prox.get("title")}</h4>
                <button class='btn'><a href='https://www.youtube.com/results?search_query=${prox.get("title")}+trailer' target="noopener">Ver Trailer</a></button><br>
                <span class="smallText">Fecha de Salida ${prox.get("release_date")}</span><br>
            </div>
        </div>

    </c:forEach>
</div>    
<style>
    body{

        height: 1000px;    
    }
    .cartelera-main img{
        z-index: -1;


    }
    .content{
        background: #FFF;
        opacity: 0.90;
        margin-top: 20%;
        height:100%;
    }
    #main{
        max-width: 100%;
        width: 100%;

    }
</style>

<!--<div>40757-->
<!--https://image.tmdb.org/t/p/w300_and_h450_bestv2/-->
<!--1955749dd63aad118485097594f67090-->

<!--https://api.themoviedb.org/4/list/40757?api_key=1955749dd63aad118485097594f67090</div>-->