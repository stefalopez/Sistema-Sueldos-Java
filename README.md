# Sistema de Gestión de Empleados y Recibos

## Descripción

El Sistema de Gestión de Empleados y Recibos es una aplicación desarrollada en Java que permite gestionar la información de los empleados, así como generar y gestionar recibos de sueldo. Está diseñado para ser utilizado por administradores y personal de recursos humanos de una organización.

## Características

### Gestión de Empleados:
- Alta de empleados.
- Baja de empleados.
- Modificación de datos de empleados.
- Consulta de información de empleados.
- Listado de todos los empleados.

### Gestión de Recibos:
- Generación de recibos de sueldo.
- Consulta de recibos de sueldo.
- Eliminación de recibos de sueldo.
- Listado de todos los recibos de un empleado.

## Requisitos

Java 8 o superior.

## Instalación

1. Clonar el repositorio:
git clone https://github.com/stefalopez/Sistema-Sueldos-Java



2. Navegar al directorio del proyecto:
cd tu-repositorio



3. Compilar el proyecto utilizando IDE (por ejemplo, IntelliJ IDEA).

## Uso

### Menú Principal
Al ejecutar la aplicación, se presenta un menú principal con las siguientes opciones:
- Gestión de Empleados
- Gestión de Recibos
- Salir

### Gestión de Empleados

#### Alta de Empleado
Permite agregar un nuevo empleado al sistema con los siguientes datos:
- Nombre
- DNI
- Fecha de Ingreso
- Tipo de Empleado (Mensual/Jornal)
- Función y Sueldo Básico Fijo (para empleados mensuales) o
- Horas Trabajadas, Valor por Hora y Cantidad de Producción (para empleados jornales).

#### Baja de Empleado
- Permite dar de baja a un empleado ingresando su Fecha de Egreso y DNI.

#### Modificación de Empleado
- Permite modificar los datos de un empleado registrado en el sistema ingresando su DNI.

#### Consulta de Empleado
- Permite visualizar la información de un empleado ingresando su DNI.

#### Listado de Todos los Empleados
- Muestra una lista de todos los empleados registrados en el sistema.

### Gestión de Recibos

#### Generación de Recibo
- Permite generar un recibo de sueldo para un empleado ingresando su DNI y el período trabajado.

#### Consulta de Recibo
- Permite visualizar un recibo de sueldo específico ingresando el DNI del empleado y el período del recibo.

#### Eliminación de Recibo
- Permite eliminar un recibo de sueldo del sistema ingresando el DNI del empleado y el período del recibo.

#### Listado de un Recibo Específico
- Muestra la información de un recibo existente ingresando el DNI del empleado y el período del recibo.

#### Listado de Todos los Recibos
- Muestra una lista de todos los recibos asociados a un empleado específico ingresando su DNI.

## Validaciones

El sistema realiza diversas validaciones para asegurar la integridad de los datos ingresados:

- **ID**: Se genera automáticamente de forma autoincremental para evitar repeticiones.
- **Nombre**: Solo puede contener letras y espacios.
- **DNI**: Debe tener entre 7 y 8 dígitos y contener solo números. Además, no puede ser un DNI que ya esté dado de alta en el sistema.
- **Fecha**: Debe estar en formato dd/MM/yyyy y ser una fecha válida.
- **Tipo de Empleado**: Debe ingresar exactamente "Mensual" o "Jornal".
- **Función**: Debe ser una función válida de la lista disponible.
- **Validaciones adicionales**:
- **Horas Trabajadas**: No pueden ser mayores a 23 y deben ser números.
- **Sueldo Básico**: Debe ser un número.
- **Cantidad de Producción**: Debe ser un número.
- **Período**: Debe ser un período válido.
- **Fecha de Egreso**: No puede ser posterior a la de Ingreso y debe tener un formato de fecha válido. Ademá
