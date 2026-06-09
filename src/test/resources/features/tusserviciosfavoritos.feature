# language: es

Característica: gestión de servicios favoritos

  @sfpf001
  Escenario: acceder a paga tu factura desde servicios favoritos
    Dado que el usuario ingrese a super app
    Cuando el usuario realiza el ingreso
    Entonces verifica version de la super app
    Y ingresa a tus servicios favoritos paga tu factura

  @sfpf002
  Escenario: descargar factura desde paga tu factura
    Dado que el usuario ingrese a super app
    Cuando el usuario realiza el ingreso
    Entonces verifica version de la super app
    Y ingresa a tus servicios favoritos paga tu factura
    Y descargar factura

  @sfpf003
  Escenario: consultar pagos automáticos desde paga tu factura
    Dado que el usuario ingrese a super app
    Cuando el usuario realiza el ingreso
    Entonces verifica version de la super app
    Y ingresa a tus servicios favoritos paga tu factura
    Y valida pagos automaticos

  @sfpf004
  Escenario: enviar factura por correo electrónico
    Dado que el usuario ingrese a super app
    Cuando el usuario realiza el ingreso
    Entonces verifica version de la super app
    Y ingresa a tus servicios favoritos paga tu factura
    Y envia factura por correo

  @sfpf005
  Escenario: consultar detalle de la última facturación
    Dado que el usuario ingrese a super app
    Cuando el usuario realiza el ingreso
    Entonces verifica version de la super app
    Y ingresa a tus servicios favoritos paga tu factura
    Y valida detalle ultima facturacion

  @sfpf006
  Escenario: consultar historial de pagos
    Dado que el usuario ingrese a super app
    Cuando el usuario realiza el ingreso
    Entonces verifica version de la super app
    Y ingresa a tus servicios favoritos paga tu factura
    Y valida historial de pagos

  @sfna001
  Escenario: acceder a la opción necesitas ayuda hogar
    Dado que el usuario ingrese a super app
    Cuando realiza el ingreso
    Entonces verifica version de la super app
    Y selecciona la opcion necesitas ayuda hogar
