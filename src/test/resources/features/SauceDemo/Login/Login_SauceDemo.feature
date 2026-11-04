# language: es
@Login
Característica: Autenticación de usuarios en SauceDemo
  Como usuario de la plataforma SauceDemo
  Quiero autenticarme con mis credenciales
  Para acceder al catálogo de productos y realizar compras

  Antecedentes:
    Dado que el usuario navega a la página de inicio de sesión
    Entonces el titulo del logo deberia mostrar "Swag Labs"

  @Smoke @Regression @QaseID=1
  Escenario: Inicio de sesión exitoso con usuario estándar
    Cuando el usuario ingresa el nombre de usuario "standard_user"
    Y ingresa la contraseña "secret_sauce"
    Y hace clic en el botón de iniciar sesión
    Entonces El título de la cabecera debería mostrar "Products"


  @QaseID=2
  Escenario: Intento de inicio de sesión con usuario bloqueado
    Cuando el usuario ingresa el nombre de usuario "locked_out_user"
    Y ingresa la contraseña "secret_sauce"
    Y hace clic en el botón de iniciar sesión
    Entonces debería ver un mensaje de error que contiene "Epic sadface: Sorry, this user has been locked out."


  @QaseID=3
  Esquema del escenario: Inicio de sesión fallido con credenciales incorrectas
    Cuando el usuario ingresa el nombre de usuario "<usuario>"
    Y ingresa la contraseña "<password>"
    Y hace clic en el botón de iniciar sesión
    Entonces debería ver un mensaje de error que contiene "Epic sadface: Username and password do not match any user in this service"

    Ejemplos:
      | usuario         | password        |
      | invalid_user    | secret_sauce    |
      | standard_user   | wrong_password  |
      | invalid_user    | wrong_password  |

  @Regression @QaseID=4
  Escenario: Recuperación de inicio de sesión tras fallo previo
    Cuando el usuario ingresa el nombre de usuario "standard_user"
    Y ingresa la contraseña "wrong_password"
    Y hace clic en el botón de iniciar sesión
    Entonces debería ver un mensaje de error que contiene "Username and password do not match"
    Cuando ingresa la contraseña "secret_sauce"
    Y hace clic en el botón de iniciar sesión
    Entonces El título de la cabecera debería mostrar "Products"

  @Performance @QaseID=5
  Escenario: Inicio de sesión con usuario de rendimiento lento sin sobrepasar el timeout
    Cuando el usuario ingresa el nombre de usuario "performance_glitch_user"
    Y ingresa la contraseña "secret_sauce"
    Y hace clic en el botón de iniciar sesión
    Entonces El título de la cabecera debería mostrar "Products"