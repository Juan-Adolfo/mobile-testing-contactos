# mobile-testing-contactos

Actividad 1 - Mobile Testing (Automatización II). Test automatizado con Appium + Java sobre la app **Contacts** de Google, descargada desde la Play Store.

## App
| | |
|---|---|
| App | Contacts (Google LLC) 4.90.16 |
| appPackage | `com.google.android.contacts` |
| appActivity | `com.android.contacts.activities.PeopleActivity` |

## Test
`tests.CreateContactTest`: crea un contacto con un nombre único, lo guarda y verifica que se muestra la pantalla de detalle con ese nombre.

## Estructura
- `device/`: creación del driver (`Android`, `Ios`, `Cloud`) mediante `FactoryDevice`.
- `sesion/`: singleton `Sesion` que mantiene el driver.
- `control/`: controles genéricos (`Button`, `TextBox`, `Label`).
- `activities/contacts/`: localizadores de cada pantalla (lista, editor y detalle).
- `tests/`: casos de prueba.

## Entorno
- JDK 26, Gradle 9.8.0, Appium 3.8.0 con driver UiAutomator2.
- Emulador Android 11 (API 30), `emulator-5554`, sin cuenta de Google para que los contactos se guarden solo en el dispositivo.

## Ejecución
```
appium
gradle test --tests tests.CreateContactTest
```

## Notas
- `appium:noReset` y `appium:forceAppLaunch`: limpiar los datos de Contacts (`pm clear`) tarda más de 20 s y la sesión fallaba por timeout; con estas opciones la app solo se reinicia en la lista de contactos.
- `appium:autoGrantPermissions`: la app pide permisos al abrir.
- La app alterna entre dos diseños del formulario (un campo "Name" o "First name"/"Last name"), por eso el nombre se escribe en el primer campo de texto y se verifica por texto.
