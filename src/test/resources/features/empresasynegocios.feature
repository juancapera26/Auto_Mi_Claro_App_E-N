# language: es

Característica: empresas y negocios

  @E&N001
  Escenario: acceder a empresas y negocios en guia y novedades
    Dado que el usuario ingrese a super app
    Cuando el usuario realiza el ingreso
    Entonces verifica version de la super app
    Y el usuario hace scroll hasta el menú Empresas y negocios
    Y ingresar a Guia y Novedades

  @E&N002
  Escenario: ingresar y validar informacion de tramintes cession de contrato
    Dado que el usuario ingrese a super app
    Cuando el usuario realiza el ingreso
    Entonces verifica version de la super app
    Y el usuario hace scroll hasta el menú Empresas y negocios
    Y ingresa a informacion de tramintes
    Y validar cession de contrato

  @E&N003
  Escenario: consultar pagos automáticos desde paga tu factura
    Dado que el usuario ingrese a super app
    Cuando el usuario realiza el ingreso
    Entonces verifica version de la super app
    Y el usuario hace scroll hasta el menú Empresas y negocios
    Y ingresa a informacion de tramintes
    Y validar cambio de plan

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
