Escribir un servicio RESTFUL.

[![Codacy Badge](https://app.codacy.com/project/badge/Grade/3dcdcad8252a434696f3d30cc075796b)](https://www.codacy.com/gh/MaQuiNa1995/EntrevistaTecnica_FootballCrud/dashboard?utm_source=github.com&amp;utm_medium=referral&amp;utm_content=MaQuiNa1995/EntrevistaTecnica_FootballCrud&amp;utm_campaign=Badge_Grade)
[![Codacy Badge](https://app.codacy.com/project/badge/Coverage/3dcdcad8252a434696f3d30cc075796b)](https://www.codacy.com/gh/MaQuiNa1995/EntrevistaTecnica_FootballCrud/dashboard?utm_source=github.com&utm_medium=referral&utm_content=MaQuiNa1995/EntrevistaTecnica_FootballCrud&utm_campaign=Badge_Coverage)

Crear un CRUD para equipos de fútbol.

# Tech Stack
- Kotlin o Java 8 (o superior)
- Springboot
- Maven


# Requisitos OBLIGATORIOS
* [x] Poder crear un equipo con las siguientes propiedades
  * [x] Nombre
  * [x] Ciudad
  * [x] Propietario
  * [x] Capacidad del estadio
  * [x] División
  * [x] Competición
  * [x] Número de jugadores
  * [x] Fecha de creación


* [x] Y validar que:
  * [x] Nombre (Obligatorio)
  * [x] Capacidad del estadio (Positivo)
  * [x] División (1, 2, 3)
  * [x] Número de jugadores (Positivo)
  * [x] Fecha de creación (Anterior a hoy)
  * [x] si Division es 1 => Capacidad del estadio debe ser mayor de 50000
  * [x] si Division es 2 => Capacidad del estadio debe ser mayor de 10000
  * [x] si Division es 3 => Capacidad del estadio debe ser mayor de 3000

* [x] Obtener una lista de todos los equipos

* [x] Obtener los detalles de un equipo específico

* [x] Generar la respuesta http de éxito o fracaso como mejor consideres en todos los end-points

# Requisitos DESEABLES
- [ ] Obtener una lista de equipos ordenados por su capacidad de estadio
- [ ] Poder actualizar los datos de un equipo, excepto la "Fecha de creación"
- [ ] Poder borrar un equipo específico
- [ ] Trazas de log
- [ ] Pruebas unitarias y de integración
- [ ] Documentar API

# Requisitos OPCIONALES
- [ ] Incluir Jenkinsfile de ejemplo build/deploy para el proyecto
- [ ] Incluir Dockerfile en el proyecto que cree un contenedor Docker que aloje el servicio web. 
- [ ] Añadir alguna forma de autenticación.
- [ ] Cualquier otra funcionalidad/cosa que consideres que aporta valor.

El objetivo no es completar al 100% el servicio para ponerlo directamente en producción, es plantear una posible solución y ser capaz de defenderlo.
