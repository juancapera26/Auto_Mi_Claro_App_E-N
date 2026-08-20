# language: es

Característica: ingresar al módulo Soluciones moviles

  @SM001
  Escenario: validar Roaming internacional
    Dado que el usuario ingrese a super app
    Cuando el usuario realiza el ingreso
    Entonces verifica version de la super app
    Y el usuario ingresa hasta el menú Soluciones móviles
    Y ingresa a Roaming internacional

  @SM002
  Escenario: Validar detalle de tu plan
    Dado que el usuario ingrese a super app
    Cuando el usuario realiza el ingreso
    Entonces verifica version de la super app
    Y el usuario ingresa hasta el menú Soluciones móviles
    Y ingresa a detalle de tu plan

  @SM003
  Escenario: Validar detalle de tu plan sona de invitados
    Dado que el usuario ingrese a super app
    Cuando el usuario cierra la sesion
    Entonces ingresa a Consulta tu plan EYP

  @SM004
  Escenario: Validar Consulta tus consumos
    Dado que el usuario ingrese a super app
    Cuando el usuario realiza el ingreso
    Y el usuario ingresa hasta el menú Soluciones móviles
    Y ingresa a Consultar tus consumos

  @SM005
  Escenario: Validar Cambio de SIM Card
    Dado que el usuario ingrese a super app
    Cuando el usuario realiza el ingreso
    Y el usuario ingresa hasta el menú Soluciones móviles
    Y ingresa a Cambio de SIM Card

  @SM006
  Escenario: Validar Activa eSIM Empresas
    Dado que el usuario ingrese a super app
    Cuando el usuario realiza el ingreso
    Y el usuario ingresa hasta el menú Soluciones móviles
    Y ingresa a Activa eSIM Empresas


  # @SM007
  # Escenario: Ir a Win play
  #  Dado que el usuario ingrese a super app
  #  Cuando el usuario realiza el ingreso
  #  Y ingresar a soluciones moviles
  #  Y