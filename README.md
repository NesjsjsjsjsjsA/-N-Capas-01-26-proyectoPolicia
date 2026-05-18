# -N-Capas-01-26-proyectoPolicia
Creado para el laboratorio de N-capas

Proyecto: BDD de una central de policia

*Entidades claves*:
  - Persona 
  {
   - Nombre
   - DUI
   - Dirección (Departamento/Calle/Colonia/Municipio)
   - Teléfono
  }
  - Cargos
  {
   - Fecha
   - Acusador
   - Acusado
   - Tipo de cargos (Procesal ó Penal)
   - Descripción del cargo
  }
  - Policia (Es una persona)
  {
   - N° de identificación del oficial
   - Placa del oficial
   - Estación policial al que pertenece
  }
  - Estación Policial
  {
    - Dirección
    - Nombre de la estación
    - Dirección de la estación
  }

*Puntos importantes sobre la descripción del proyecto*
1. Municipios, departamentos y algunas calles deben de estar ingresadas ya en el sistema (Como un catálogo)
2. Son mínimo dos estaciones de policia
3. Oficiales (Policia) ya deben de estar en el sistema (un mínimo de 4) al igual que las personas (un mínimo de 6)
4. Es importante manejar Excepciones es decir que si alguien intenta ingresar un código de un policia que no existe, deberá de lanzar una excepción!

*¿Cómo debe de ser las llamadas?*
Se quiere registrar el cargo a una _persona_ :
  - Se requieren los datos de la persona
  - Lista de los cargos que ha cometido, lo que esos cargos deberán de contener son:
        - Tipo
        - Código del policia
        - Acusador, lo que el acusador deberá de contener es:
            - Nombre
            - Dui
            
*End points _opcionales_(pero son MUY requeridos)*
- Registrar una persona
- Registrar cargos
- Buscar todas las peticiones que sí tengan cargis
- Los 3 más buscados
