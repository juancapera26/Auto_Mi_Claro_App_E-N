
# language: es

Característica: Acceso a las funcionalidades del módulo Pagos y Consultas

  @PC001
  Escenario: Acceder a la opción Devolución de equipos
    Dado QUE EL USUARIO INGRESE A SUPER APP
    Cuando REALIZA EL INGRESO
    Y INGRESA AL MENU PAGOS Y CONSULTAS
    Entonces INGRESA A DEVOLUCION DE EQUIPOS

  @PC002
  Escenario: Acceder a la opción Solicitar traslado
    Dado QUE EL USUARIO INGRESE A SUPER APP
    Cuando REALIZA EL INGRESO
    Y INGRESA AL MENU PAGOS Y CONSULTAS
    Entonces INGRESA A SOLICITAR TRASLADOS

  @PC003
  Escenario: Acceder a la opción Reiniciar módem
    Dado QUE EL USUARIO INGRESE A SUPER APP
    Cuando REALIZA EL INGRESO
    Y INGRESA AL MENU PAGOS Y CONSULTAS
    Entonces INGRESA A REINICIAR MODEM

  @PC004
  Escenario: Consultar el detalle del plan
    Dado QUE EL USUARIO INGRESE A SUPER APP
    Cuando REALIZA EL INGRESO
    Y INGRESA AL MENU PAGOS Y CONSULTAS
    Entonces VALIDA DETALLE DE TU PLAN

  @PC005
  Escenario: Acceder a la opción Administrar tu red WiFi
    Dado QUE EL USUARIO INGRESE A SUPER APP
    Cuando REALIZA EL INGRESO
    Y INGRESA AL MENU PAGOS Y CONSULTAS
    Entonces INGRESA A ADMINISTRAR TU RED WIFI

  @PC006
  Escenario: Consultar productos disponibles para adquirir
    Dado QUE EL USUARIO INGRESE A SUPER APP
    Cuando REALIZA EL INGRESO
    Y INGRESA AL MENU PAGOS Y CONSULTAS
    Y INGRESA ADQUIRIR PRODUCTO
    Y VALIDA MODULO INTERNET
    Y VALIDA MODULO TELEVISION
    Y VALIDA MODULO TELEFONO
    Entonces VALIDA MODULO ULTRA WIFI

  @PC011
  Escenario: Acceder al módulo de Pagos
    Dado QUE EL USUARIO INGRESE A SUPER APP
    Cuando REALIZA EL INGRESO
    Y INGRESA AL MENU PAGOS Y CONSULTAS
    Entonces DIRECCIONAMIENTO CORRECTO PAGOS
