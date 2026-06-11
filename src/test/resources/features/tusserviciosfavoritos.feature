# language: es

Característica: gestión de servicios favoritos

  @SFPF001
  Escenario: acceder a paga tu factura desde servicios favoritos
    Dado que el usuario ingrese a super app
    Cuando el usuario realiza el ingreso
    Entonces verifica version de la super app
    Y ingresa a tus servicios favoritos paga tu factura

  @SFPF002
  Escenario: descargar factura desde paga tu factura
    Dado que el usuario ingrese a super app
    Cuando el usuario realiza el ingreso
    Entonces verifica version de la super app
    Y ingresa a tus servicios favoritos paga tu factura
    Y descargar factura

  @SFPF003
  Escenario: consultar pagos automáticos desde paga tu factura
    Dado que el usuario ingrese a super app
    Cuando el usuario realiza el ingreso
    Entonces verifica version de la super app
    Y ingresa a tus servicios favoritos paga tu factura
    Y valida pagos automaticos

  @SFPF004
  Escenario: enviar factura por correo electrónico
    Dado que el usuario ingrese a super app
    Cuando el usuario realiza el ingreso
    Entonces verifica version de la super app
    Y ingresa a tus servicios favoritos paga tu factura
    Y envia factura por correo

  @SFPF005
  Escenario: consultar detalle de la última facturación
    Dado que el usuario ingrese a super app
    Cuando el usuario realiza el ingreso
    Entonces verifica version de la super app
    Y ingresa a tus servicios favoritos paga tu factura
    Y valida detalle ultima facturacion

  @SFPF006
  Escenario: consultar historial de pagos
    Dado que el usuario ingrese a super app
    Cuando el usuario realiza el ingreso
    Entonces verifica version de la super app
    Y ingresa a tus servicios favoritos paga tu factura
    Y valida historial de pagos

  @SFNA001
  Escenario: acceder a la opción necesitas ayuda hogar
    Dado que el usuario ingrese a super app
    Cuando el usuario realiza el ingreso
    Entonces verifica version de la super app
    Y selecciona la opcion necesitas ayuda hogar
