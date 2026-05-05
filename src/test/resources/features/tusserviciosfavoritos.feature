Feature: Tus servicios favoritos


  @SFPF001
  Scenario: Ingresar a servicios favoritos y pagar factura
    Given EL USUARIO ABRE LA SUPER APP
    When  REALIZA EL INGRESO
    Then VERIFICA VERSION DE LA SUPER APP
    And INGRESA A TUS SERVICIOS FAVORITOS PAGA TU FACTURA

  @SFPF002
  Scenario: Ingresar a servicios favoritos y pagar factura descarga tu factura
    Given EL USUARIO ABRE LA SUPER APP
    When  REALIZA EL INGRESO
    Then VERIFICA VERSION DE LA SUPER APP
    And INGRESA A TUS SERVICIOS FAVORITOS PAGA TU FACTURA
    And DESCARGAR FACTURA

  @SFPF003
  Scenario: Ingresar a servicios favoritos y pagar factura pagos automaticos
    Given EL USUARIO ABRE LA SUPER APP
    When  REALIZA EL INGRESO
    Then VERIFICA VERSION DE LA SUPER APP
    And INGRESA A TUS SERVICIOS FAVORITOS PAGA TU FACTURA
    And VALIDA PAGOS AUTOMATICOS

  @SFPF004
  Scenario: Ingresar a servicios favoritos y enviar factura por correo
    Given EL USUARIO ABRE LA SUPER APP
    When  REALIZA EL INGRESO
    Then VERIFICA VERSION DE LA SUPER APP
    And INGRESA A TUS SERVICIOS FAVORITOS PAGA TU FACTURA
    And ENVIA FACTURA POR CORREO

  @SFPF005
  Scenario: Ingresar a servicios favoritos y detalle ultima facturacion
    Given EL USUARIO ABRE LA SUPER APP
    When  REALIZA EL INGRESO
    Then VERIFICA VERSION DE LA SUPER APP
    And INGRESA A TUS SERVICIOS FAVORITOS PAGA TU FACTURA
    And VALIDA DETALLE ULTIMA FACTURACION


  @SFPF006
  Scenario: Ingresar a servicios favoritos y historial de pagos
    Given EL USUARIO ABRE LA SUPER APP
    When  REALIZA EL INGRESO
    Then VERIFICA VERSION DE LA SUPER APP
    And INGRESA A TUS SERVICIOS FAVORITOS PAGA TU FACTURA
    And  VALIDA HISTORIAL DE PAGOS

  @SFPF007
  Scenario: Ingresar a servicios favoritos y pagar factura por correo
    Given EL USUARIO ABRE LA SUPER APP
    When  REALIZA EL INGRESO
    Then VERIFICA VERSION DE LA SUPER APP
    And INGRESA A TUS SERVICIOS FAVORITOS PAGA TU FACTURA
    And  VALIDA HISTORIAL DE PAGOS

  @SFNA001
  Scenario: Ingresar a servicios favoritos y necesitas ayuda
    Given EL USUARIO ABRE LA SUPER APP
    When  REALIZA EL INGRESO
    Then VERIFICA VERSION DE LA SUPER APP
    And SELECCIONA LA OPCION NECESITAS AYUDA HOGAR





