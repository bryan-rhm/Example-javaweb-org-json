<c:choose>
    <c:when test="${ empty cliente.getNombre()}">
        <h2>Para comenzar necesitamos saber un poco de ti</h2>

      <form action="setnombre" method="POST"> 
          <input type="text"  placeholder="Ingresa tu nombre" name="nombre" required>
          <br>
          <br>
          <input type="submit" class="btn" value="Ingresar">
      </form>        
    </c:when>
      <c:otherwise>
          <div class="welcome-text">
          <h3>Bienvenido ${cliente.getNombre()}</h3>
          <hr>
         <h4>Ingresa a nuestra cartelera </h4>
          
         <button class="btn"><a href="cartelera">Cartelera</a></button>
          </div>
      </c:otherwise>
</c:choose>

 

