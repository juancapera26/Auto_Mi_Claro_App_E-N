
# language: es

Característica: acceso a las funcionalidades del módulo pagos y consultas

  #en ejecucion revision por cahcha
  @PC001
  Escenario: Validar Pagos en línea en Soluciones Móviles - Redirección a PSE
    Dado que el usuario ingrese a super app
    Cuando el usuario realiza el ingreso
    Entonces verifica version de la super app
    Y ingresar a pagos y facturas
    Y ingresa a Pagos en linea Soluciones moviles
    Y Validar medio de pago PSE

  @PC002
  Escenario: Validar Pagos en línea en Soluciones Móviles - Tarjeta de Crédito - Débito
    Dado que el usuario ingrese a super app
    Cuando el usuario realiza el ingreso
    Entonces verifica version de la super app
    Y ingresar a pagos y facturas
    Y ingresa a Pagos en linea Soluciones moviles
    Y Validar medio de pago Tarjeta de Crédito - Débito

  @PC003
  Escenario: Validar Pagos en línea en Soluciones Móviles - Redirección a Bancolombia
    Dado que el usuario ingrese a super app
    Cuando el usuario realiza el ingreso
    Entonces verifica version de la super app
    Y ingresar a pagos y facturas
    Y ingresa a Pagos en linea Soluciones moviles
    Y Validar medio de pago Bancolombia

  @PC004
  Escenario: Validar Pagos en línea en Soluciones Fijas HFC - Redirección a PSE
    Dado que el usuario ingrese a super app
    Cuando el usuario realiza el ingreso
    Entonces verifica version de la super app
    Y ingresar a pagos y facturas
    Y ingresa a Pagos en linea Soluciones Fijas HFC
    Y Validar medio de pago PSE

  @PC005
  Escenario: Validar Pagos en línea en Soluciones Fijas HFC - Tarjeta de Crédito - Débito
    Dado que el usuario ingrese a super app
    Cuando el usuario realiza el ingreso
    Entonces verifica version de la super app
    Y ingresar a pagos y facturas
    Y ingresa a Pagos en linea Soluciones Fijas HFC
    Y Validar medio de pago Tarjeta de Crédito - Débito

  @PC006
  Escenario: Validar Pagos en línea en Soluciones Fijas HFC - Redirección a Bancolombia
    Dado que el usuario ingrese a super app
    Cuando el usuario realiza el ingreso
    Entonces verifica version de la super app
    Y ingresar a pagos y facturas
    Y ingresa a Pagos en linea Soluciones Fijas HFC
    Y Validar medio de pago Bancolombia




