
# language: es

Característica: acceso a las funcionalidades del módulo pagos y consultas

  @pc001
  Escenario: acceder a la opción devolución de equipos
    Dado que el usuario ingrese a super app
    Cuando el usuario realiza el ingreso
    Y el usuario hace scroll hasta el menú Pagos y consultas
    Entonces ingresa a devolución de equipos

  @pc002
  Escenario: acceder a la opción solicitar traslado
    Dado que el usuario ingrese a super app
    Cuando el usuario realiza el ingreso
    Y el usuario hace scroll hasta el menú Pagos y consultas
    Entonces ingresa a solicitar traslado

  @pc003
  Escenario: acceder a la opción reiniciar módem
    Dado que el usuario ingrese a super app
    Cuando el usuario realiza el ingreso
    Y el usuario hace scroll hasta el menú Pagos y consultas
    Entonces ingresa a reiniciar módem

  @pc004
  Escenario: consultar el detalle del plan
    Dado que el usuario ingrese a super app
    Cuando el usuario realiza el ingreso
    Y el usuario hace scroll hasta el menú Pagos y consultas
    Entonces valida detalle de tu plan

  @pc005
  Escenario: acceder a la opción administrar tu red wifi
    Dado que el usuario ingrese a super app
    Cuando el usuario realiza el ingreso
    Y el usuario hace scroll hasta el menú Pagos y consultas
    Entonces ingresa a administrar tu red wifi

  @pc006
  Escenario: consultar productos disponibles para adquirir
    Dado que el usuario ingrese a super app
    Cuando el usuario realiza el ingreso
    Y el usuario hace scroll hasta el menú Pagos y consultas
    Y ingresa a adquirir producto
    Y valida el módulo internet
    Y valida el módulo televisión
    Y valida el módulo teléfono
    Entonces valida el módulo ultra wifi

  @pc011
  Escenario: acceder al módulo de pagos
    Dado que el usuario ingrese a super app
    Cuando el usuario realiza el ingreso
    Y el usuario hace scroll hasta el menú Pagos y consultas
    Entonces valida la redirección a Pagos
