Feature: Tus servicios favoritos


  @SFPF01
  Scenario: Ingresar a servicios favoritos y pagar factura
    Given EL USUARIO ABRE LA SUPER APP
    When  REALIZA EL INGRESO
    Then VERIFICA VERSION DE LA SUPER APP
    And INGRESA A TUS SERVICIOS FAVORITOS PAGA TU FACTURA

  @SFPF02
  Scenario: Ingresar a servicios favoritos y pagar factura descarga tu factura
    Given EL USUARIO ABRE LA SUPER APP
    When  REALIZA EL INGRESO
    Then VERIFICA VERSION DE LA SUPER APP
    And INGRESA A TUS SERVICIOS FAVORITOS PAGA TU FACTURA
    And DESCARGAR FACTURA

  @SFPF03
  Scenario: Ingresar a servicios favoritos y pagar factura pagos automaticos
    Given EL USUARIO ABRE LA SUPER APP
    When  REALIZA EL INGRESO
    Then VERIFICA VERSION DE LA SUPER APP
    And INGRESA A TUS SERVICIOS FAVORITOS PAGA TU FACTURA
    And VALIDA PAGOS AUTOMATICOS

  @SFPF04
  Scenario: Ingresar a servicios favoritos y enviar factura por correo
    Given EL USUARIO ABRE LA SUPER APP
    When  REALIZA EL INGRESO
    Then VERIFICA VERSION DE LA SUPER APP
    And INGRESA A TUS SERVICIOS FAVORITOS PAGA TU FACTURA
    And ENVIA FACTURA POR CORREO

  @SFPF05
  Scenario: Ingresar a servicios favoritos y detalle ultima facturacion
    Given EL USUARIO ABRE LA SUPER APP
    When  REALIZA EL INGRESO
    Then VERIFICA VERSION DE LA SUPER APP
    And INGRESA A TUS SERVICIOS FAVORITOS PAGA TU FACTURA
    And VALIDA DETALLE ULTIMA FACTURACION


  @SFPF06
  Scenario: Ingresar a servicios favoritos y historial de pagos
    Given EL USUARIO ABRE LA SUPER APP
    When  REALIZA EL INGRESO
    Then VERIFICA VERSION DE LA SUPER APP
    And INGRESA A TUS SERVICIOS FAVORITOS PAGA TU FACTURA
    And  VALIDA HISTORIAL DE PAGOS

  @SFPF07
  Scenario: Ingresar a servicios favoritos y pagar factura por correo
    Given EL USUARIO ABRE LA SUPER APP
    When  REALIZA EL INGRESO
    Then VERIFICA VERSION DE LA SUPER APP
    And INGRESA A TUS SERVICIOS FAVORITOS PAGA TU FACTURA
    And  VALIDA HISTORIAL DE PAGOS

  @SFNA01
  Scenario: Ingresar a servicios favoritos y necesitas ayuda
    Given EL USUARIO ABRE LA SUPER APP
    When  REALIZA EL INGRESO
    Then VERIFICA VERSION DE LA SUPER APP
    And SELECCIONA LA OPCION NECESITAS AYUDA HOGAR


  @SFST01
  Scenario: Ingresar a servicios favoritos y necesitas ayuda
    Given EL USUARIO ABRE LA SUPER APP
    When  REALIZA EL INGRESO
    Then VERIFICA VERSION DE LA SUPER APP
    And DESPLAZA HASTA CUENTA Y SELECCIONA VER DETALLE SERVICIOS TECNICOS


