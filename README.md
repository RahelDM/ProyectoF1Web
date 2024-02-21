# :racing_car: :dash: Proyecto F1 

##  Página de inicio
![image](https://github.com/RaquelSA34/ProyectoF1Web/assets/145332620/12683b9b-db61-48dd-8eb2-716951a07555)

Para crear las tres tarjetas de pilotos y que estas muestren pilotos aleatorios conforme se recarga la página se han establecido en el AppController varios métodos para obtener números aleatorios que permitan, a través de una consulta, devolver pilotos distintos. 

```
    public void getPilotosAlAzar(Model model){
        int desde = generarNumAleatorio(MAX, MIN);
        List<Piloto> pilotoList = pilotoService.findPilotosAlAzar(desde, desde+ NEXT);
        model.addAttribute("pilotosAzar",pilotoList); //cargamos la lista de pilotos al azar
    }
```
Siendo así la consulta usada:
```
       @Query("FROM Piloto WHERE numero BETWEEN :desde AND :hasta")
```
Para establecer los pilotos en el modelo, se ha usado un fragmento que será reutilizado después para el listado de pilotos.
![image](https://github.com/RaquelSA34/ProyectoF1Web/assets/145332620/45a041d9-2584-43de-a577-730e758daf25)


##  Pilotos :racing_car:
### Listado Pilotos
En la clase PilotoController se ha establecido un @GetMapping("") con @RequestMapping("/pilotos") en el que se añade la lista de todos los pilotos al modelo.
```
 @GetMapping("")
    public String getPilotos(Model model) {
        List<Piloto> pilotoList = pilotoService.findAllPilotos();
        model.addAttribute("pilotos", pilotoList);
        return "piloto/pilotos";
    }
```
En la vista de "pilotos.html", se itera sobre esta lista de pilotos empleando el fragmento configurado con anterioridad.
![image](https://github.com/RaquelSA34/ProyectoF1Web/assets/145332620/f2a604ce-ffdf-47e9-8441-f10febaf570c)

Siendo así el resultado final:
![image](https://github.com/RaquelSA34/ProyectoF1Web/assets/145332620/b3ead222-787e-4a90-995b-643dfbc024f1)

### :mag: Detalle Piloto
Se ha usado el siguiente método @GetMapping("/{id}") en la clase PilotoController para establecer una ruta que reciba el id de piloto y se muestre la vista concreta, "piloto.html".
```
   @GetMapping("/{id}")
    public String getPilotoById(Model model, @PathVariable Long id) {
        Optional<Piloto> pilotoOptional = pilotoService.findPilotoById(id);
        if (pilotoOptional.isPresent()) {
            model.addAttribute("piloto", pilotoOptional.get());
        } else {
            model.addAttribute("msg", "Sin pilotos con id: " + id);
        }
        return "piloto/piloto";
    }
```
La ruta se establece en el fragmeto th:fragment="tarjeta-piloto".

![image](https://github.com/RaquelSA34/ProyectoF1Web/assets/145332620/9ca45ded-43d4-42d4-862d-f6024b5fc6e4)

Se configura el archivo "piloto.html" y la vista final queda así:

![image](https://github.com/RaquelSA34/ProyectoF1Web/assets/145332620/5106ddc2-1ed1-4b00-82b0-32049ba8705d)

Siendo la ruta de enlace la siguiente:

![image](https://github.com/RaquelSA34/ProyectoF1Web/assets/145332620/23a65e10-9844-47e5-b0cb-3882bf30b2bf)


### Formulario Piloto
Se utilizará el mismo archivo html tanto para actualizar como para añadir. Para esto se necesitarán dos métodos @GetMapping(). 
Uno para mostrar la vista del formulario "pilotoForm.html" preparada para actualizar y añadir. Utilizaremos para diferenciar los campos que se mostrarán y personalizando la vista usando el atributo "nuevo".
Mostramos el piloto a actualizar:
```
  @GetMapping("/pilotoForm/{id}")
    public String updatePiloto(Model model, @PathVariable Long id) {
        Optional<Piloto> pilotoOptional = pilotoService.findPilotoById(id);
        if (pilotoOptional.isPresent()) { //el piloto a actualizar existe
            model.addAttribute("piloto", pilotoOptional.get()); //el piloto para actualizar
            model.addAttribute("nuevo", false);
            return "piloto/pilotoForm";
        } else {
            model.addAttribute("msg", "No hay un piloto con id: " + id);
        }
        return "redirect:/pilotos"; //si se produce algún error y no se accede al formulario...
    }
```
Mostramos un piloto sin datos en el formulario, para rellenar:
```
  @GetMapping("/piloto/add")
    public String savePiloto(Model model) {
        Piloto piloto = new Piloto();
        model.addAttribute("piloto", piloto);
        model.addAttribute("nuevo", true);
        return "piloto/pilotoForm";
    }
```
La vista del formulario debe se establecer la acción que se ejecutará cuando el botón de "Guardar" o "Modificar". El id será un campo de solo lectura que aparecerá únicamente en la actualización.

![image](https://github.com/RaquelSA34/ProyectoF1Web/assets/145332620/ee709476-3183-447c-b49f-d711e33c906f)

#### :repeat: Actualizar
El método que se ocupa de actualizar:
```
  @PutMapping("/piloto/save")
    public String updatePiloto(@ModelAttribute(value = "pilotoFormulario") Piloto pilotoFormulario) {
        pilotoService.save(pilotoFormulario);
        return "redirect:/pilotos/" + pilotoFormulario.getPilotoId();
    }
```
#### :heavy_plus_sign: Añadir
El método que se ocupa de añadir:
```
 @PostMapping("/piloto/save")
    public String savePiloto(@ModelAttribute(value = "pilotoFormulario") Piloto pilotoFormulario) {
        pilotoService.save(pilotoFormulario);
        return "redirect:/pilotos/" + pilotoFormulario.getPilotoId();
    }
```
Ejemplos Actualización
![image](https://github.com/RaquelSA34/ProyectoF1Web/assets/145332620/cfe05c77-d4a0-4697-a815-103f07cf038e)
![image](https://github.com/RaquelSA34/ProyectoF1Web/assets/145332620/234a1f7f-1241-4869-80e9-4bb8368eece7)
Ejemplos Agregar Piloto


![image](https://github.com/RaquelSA34/ProyectoF1Web/assets/145332620/a6a59f1a-2075-4828-952a-a98647d7f3cd)
![image](https://github.com/RaquelSA34/ProyectoF1Web/assets/145332620/8ee5726b-c990-4bd4-a06b-53adf5f1f1fe)
![image](https://github.com/RaquelSA34/ProyectoF1Web/assets/145332620/4cd4713c-d028-4795-b722-bb41a3c202f9)
![image](https://github.com/RaquelSA34/ProyectoF1Web/assets/145332620/e106bfc8-c10b-4166-b9ee-cccab8238501)

##  Circuitos :checkered_flag: 
### Listado Circuitos
Para mostrar el listado de circuitos el archivo circuitos.html recibe una lista de todos los circuitos. Se itera sobre esta lista sin necesidad de usar fragmentos.
![image](https://github.com/RaquelSA34/ProyectoF1Web/assets/145332620/97c61cdb-73f3-44ee-a6fc-e59768cb17c9)
En el controlador de Circuito, el método encargado de cargar la vista adecuada es el siguiente:
```
    @GetMapping()
    public String getCircuitos(Model model){
        List<Circuito> circuitos = this.circuitoService.findAllCircuitos();
        model.addAttribute("circuitos", circuitos);
        return "circuito/circuitos";
    }
```
El @RequestMapping() es: @RequestMapping("/circuitos")
![image](https://github.com/RaquelSA34/ProyectoF1Web/assets/145332620/6c6eb6d8-bac6-44be-96b9-81bc45c46e67)

### :mag: Detalle Circuito
Para detallar un circuito se usa el archivo "circuito.html", cuyo funcionamiento es similar al del "piloto.html", recibiendo el id del circuito a mostrar.

![image](https://github.com/RaquelSA34/ProyectoF1Web/assets/145332620/b2bd3c9b-a6db-4159-82a1-e96c9d9355d0)
```
    @GetMapping("/circuito/{id}")
    public String getCircuitoById(Model model, @PathVariable Long id){
        Optional<Circuito> circuitoOptional = this.circuitoService.findCircuitoById(id);
        if(circuitoOptional.isPresent()){
            model.addAttribute("circuitoADetallar", circuitoOptional.get());
        }else{
            model.addAttribute("msg", "No existe el circuito con id " + id);
        }
        return "circuito/circuito";
    }
```
### Formulario Circuito
Su funcionamiento es similar al del piloto.
Dos métodos para mostrar la vista según se vaya a actualizar o añadir.

Para actualizar:
```
 @GetMapping("/circuitoForm/{id}")
    public String updateCircuito(Model model, @PathVariable Long id){
        Optional<Circuito> circuitoOptional = this.circuitoService.findCircuitoById(id);
        if(circuitoOptional.isPresent()){
            model.addAttribute("circuitoFormulario", circuitoOptional.get());
            model.addAttribute("nuevo", false); //vamos a actualizar el circuito, no crearlo
        }else{
            model.addAttribute("msg", "No existe el circuito con id " + id);
        }
        return "circuito/circuitoForm";
    }
```
Para añadir:
```
 @GetMapping("/circuito/add")
    public String addCircuito(Model model){
        Circuito circuito = new Circuito();
        model.addAttribute("circuitoFormulario", circuito); //el que recibirá el formulario
        model.addAttribute("nuevo", true); //vamos a añadir el circuito, no actualizarlo
        return "circuito/circuitoForm";
    }
```
Teniendo los siguientes métodos para actualizar y añadir:
```
   @PostMapping("/circuito/save") // /circuitos/circuito/save
    public String saveCircuito(Model model, @ModelAttribute(value = "circuitoFormulario") Circuito circuito){
        this.circuitoService.save(circuito);
        return "redirect:/circuitos/circuito/"+circuito.getCircuitoId();
    }

    @PutMapping("/circuito/save") // /circuitos/circuito/save
    public String updateCircuito(Model model, @ModelAttribute(value = "circuitoFormulario") Circuito circuito){
        this.circuitoService.save(circuito);
        return "redirect:/circuitos/circuito/"+circuito.getCircuitoId();
    }
```
#### :repeat: Actualizar

![image](https://github.com/RaquelSA34/ProyectoF1Web/assets/145332620/22e99b1e-5b43-4ecf-9474-2bd5ad2804d4)
![image](https://github.com/RaquelSA34/ProyectoF1Web/assets/145332620/fa1be44e-c022-4be3-b100-7a5b0a22bdf6)

#### :heavy_plus_sign: Añadir

![image](https://github.com/RaquelSA34/ProyectoF1Web/assets/145332620/aab5b8f0-8979-42e2-87d6-b16750e20255)

![image](https://github.com/RaquelSA34/ProyectoF1Web/assets/145332620/a3dbc988-ad06-4cde-b1d8-89f2a8ecf39e)

![image](https://github.com/RaquelSA34/ProyectoF1Web/assets/145332620/404cd5d1-a1d3-4e6f-af84-9ca3ef0b8d41)

![image](https://github.com/RaquelSA34/ProyectoF1Web/assets/145332620/cb365801-7d74-44cd-807f-8971203535bc)


##  Resultados :trophy:
### Listado de Resultados
Se ha utilizado la siguiente consulta:
```
  @Query("FROM Resultado r ORDER BY r.circuito.nombre ASC, r.posicionLlegada ASC")
     List<Resultado> findAllResultadosOrdenados();
```

![image](https://github.com/RaquelSA34/ProyectoF1Web/assets/145332620/4575b08d-0301-4c04-8c98-79f022657708)

### Buscar
Se ha usado la siguiente consulta:
```
  @Query("FROM Resultado r WHERE r.circuito.nombre LIKE %:cadena% OR r.piloto.nombre LIKE %:cadena% OR r.piloto.equipo LIKE %:cadena% ")
     List<Resultado> findResultadosByWord(String cadena);
```
![image](https://github.com/RaquelSA34/ProyectoF1Web/assets/145332620/a4a83b90-7610-449c-ab37-97695ba63af2)

Para gestionar el CSS de los colores se aplicó lo siguiente:

![image](https://github.com/RaquelSA34/ProyectoF1Web/assets/145332620/0dd6c7da-929a-41da-992c-cd36931134a0)


### Clasificación Pilotos

Se ha usado las siguientes consultas:

```
    @Query("""
    SELECT new org.pspr.entrega_formula.dto.ResultadoDTO(r.piloto, 
        SUM(
            CASE 
                WHEN r.posicionLlegada = 1 THEN 25
                WHEN r.posicionLlegada = 2 THEN 18
                WHEN r.posicionLlegada = 3 THEN 15
                WHEN r.posicionLlegada = 4 THEN 12
                WHEN r.posicionLlegada = 5 THEN 10
                WHEN r.posicionLlegada = 6 THEN 8
                WHEN r.posicionLlegada = 7 THEN 6
                WHEN r.posicionLlegada = 8 THEN 4
                WHEN r.posicionLlegada = 9 THEN 2
                WHEN r.posicionLlegada = 10 THEN 1
                ELSE 0 
            END
        )) 
    FROM Resultado r 
    GROUP BY r.piloto 
    ORDER BY  SUM(
            CASE 
                WHEN r.posicionLlegada = 1 THEN 25
                WHEN r.posicionLlegada = 2 THEN 18
                WHEN r.posicionLlegada = 3 THEN 15
                WHEN r.posicionLlegada = 4 THEN 12
                WHEN r.posicionLlegada = 5 THEN 10
                WHEN r.posicionLlegada = 6 THEN 8
                WHEN r.posicionLlegada = 7 THEN 6
                WHEN r.posicionLlegada = 8 THEN 4
                WHEN r.posicionLlegada = 9 THEN 2
                WHEN r.posicionLlegada = 10 THEN 1
                ELSE 0 
            END
        ) DESC 
""")
     List<ResultadoDTO> findPilotosPuntos();
```

Para obtener el piloto con más victorias:

```
@Query("""
            SELECT new org.pspr.entrega_formula.dto.PilotoDTO(r.piloto,count(r.piloto.pilotoId))
            FROM Resultado r where r.posicionLlegada=1 GROUP BY r.piloto.pilotoId ORDER BY count(r.piloto.pilotoId) DESC LIMIT 1
            """)
    PilotoDTO findPilotoMasVictorias();
```

![image](https://github.com/RaquelSA34/ProyectoF1Web/assets/145332620/a7e98d00-b0f0-4c39-84e1-410d70a6353b)

En la vista se ha configurado el html de la siguiente manera:

![image](https://github.com/RaquelSA34/ProyectoF1Web/assets/145332620/c662898e-a42f-457a-bc7a-176f15c9c1a6)

El método del  @GetMapping("") usado ha sido:
```
  @GetMapping("/pilotos")
    public String getPilotosClasificacion(Model model) {
        List<ResultadoDTO> resultados = resultadoService.findPilotosPuntos();
        model.addAttribute("resultados", resultados);
        PilotoDTO pilotoMasVictorias = pilotoService.findPilotoMasVictorias();
        model.addAttribute("pilotoMasVictorias", pilotoMasVictorias);
        return "resultado/clasificacionPilotos";
    }
```

### Clasificación Equipos

Se ha usado la siguiente consulta:

```
 @Query("""
    SELECT new org.pspr.entrega_formula.dto.ResultadoDTO(r.piloto.equipo, 
        SUM(
            CASE 
                WHEN r.posicionLlegada = 1 THEN 25
                WHEN r.posicionLlegada = 2 THEN 18
                WHEN r.posicionLlegada = 3 THEN 15
                WHEN r.posicionLlegada = 4 THEN 12
                WHEN r.posicionLlegada = 5 THEN 10
                WHEN r.posicionLlegada = 6 THEN 8
                WHEN r.posicionLlegada = 7 THEN 6
                WHEN r.posicionLlegada = 8 THEN 4
                WHEN r.posicionLlegada = 9 THEN 2
                WHEN r.posicionLlegada = 10 THEN 1
                ELSE 0 
            END
        )) 
    FROM Resultado r 
    GROUP BY r.piloto.equipo
    ORDER BY  SUM(
            CASE 
                WHEN r.posicionLlegada = 1 THEN 25
                WHEN r.posicionLlegada = 2 THEN 18
                WHEN r.posicionLlegada = 3 THEN 15
                WHEN r.posicionLlegada = 4 THEN 12
                WHEN r.posicionLlegada = 5 THEN 10
                WHEN r.posicionLlegada = 6 THEN 8
                WHEN r.posicionLlegada = 7 THEN 6
                WHEN r.posicionLlegada = 8 THEN 4
                WHEN r.posicionLlegada = 9 THEN 2
                WHEN r.posicionLlegada = 10 THEN 1
                ELSE 0 
            END
        ) DESC 
""")
     List<ResultadoDTO> findEquiposPuntos();

```

![image](https://github.com/RaquelSA34/ProyectoF1Web/assets/145332620/3e177f1c-0982-4ec9-b0b5-2fde7b62925d)


En la vista se ha configurado el html de la siguiente manera:

![image](https://github.com/RaquelSA34/ProyectoF1Web/assets/145332620/ab69c368-e67a-43bb-aef9-77050e08ec7a)

El método del  @GetMapping("") usado ha sido:
```
 @GetMapping("/equipos")
    public String getEquiposClasificacion(Model model) {
        List<ResultadoDTO> resultados = resultadoService.findEquiposPuntos();
        model.addAttribute("resultados", resultados);
        return "resultado/clasificacionEquipos";
    }
```

