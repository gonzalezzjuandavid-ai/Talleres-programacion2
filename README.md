**Elaborado por: Juan David Gonzalez**

# Taller de Nivelación PI a PII

## Preguntas de GIT:

* **Pregunta 1:** ¿Qué es un repositorio en Git y cómo se diferencia de un proyecto "normal"?

  **Respuesta:** Un repositorio en Git es un directorio que contiene todos los archivos de un proyecto junto con un subdirectorio oculto `.git` que almacena todo el historial de cambios, ramas y configuraciones. A diferencia de un proyecto normal (que solo tiene los archivos actuales), un repositorio Git guarda cada versión de cada archivo, permitiendo volver a estados anteriores, comparar cambios y colaborar con otros desarrolladores sin perder información.

* **Pregunta 2:** ¿Cuáles son las tres áreas principales de Git y qué papel cumple cada una?

  **Respuesta:** Las tres áreas son:
  - **Working Directory (Directorio de trabajo):** Es la carpeta donde se editan los archivos directamente. Contiene la versión actual de los archivos en la que se está trabajando.
  - **Staging Area / Index (Área de preparación):** Es un área intermedia donde se colocan los cambios que se quieren incluir en el próximo commit. Actúa como una zona de revisión antes de confirmar los cambios.
  - **Repository (Repositorio / .git):** Es donde Git almacena permanentemente los commits con todo el historial del proyecto. Cada commit es una instantánea del estado del proyecto.

* **Pregunta 3:** ¿Cómo representa Git los cambios internamente?

  **Respuesta:** Git utiliza cuatro tipos de objetos internos:
  - **Blob (Binary Large Object):** Almacena el contenido de un archivo individual, sin nombre ni metadatos.
  - **Tree:** Representa un directorio. Contiene referencias a blobs (archivos) y a otros trees (subdirectorios), junto con sus nombres y permisos.
  - **Commit:** Apunta a un tree (la instantánea del proyecto), contiene el autor, la fecha, el mensaje del commit y una referencia al commit padre.
  - **Tag:** Es una referencia con nombre a un commit específico, usada generalmente para marcar versiones (v1.0, v2.0, etc.).

* **Pregunta 4:** ¿Cómo se crea un commit y qué información almacena?

  **Respuesta:** Se crea un commit en dos pasos: primero se agregan los archivos al staging area con `git add` y luego se confirman con `git commit -m "mensaje"`. Un objeto commit almacena: una referencia al tree raíz (instantánea del proyecto), referencia(s) al commit padre, nombre y correo del autor, nombre y correo del committer, la fecha y hora, y el mensaje descriptivo del commit.

* **Pregunta 5:** ¿Cuál es la diferencia entre git pull y git fetch?

  **Respuesta:** `git fetch` descarga los cambios del repositorio remoto al repositorio local, pero no los integra en la rama de trabajo actual; solo actualiza las referencias remotas para que se puedan revisar antes de fusionar. `git pull` hace un `git fetch` seguido automáticamente de un `git merge`, es decir, descarga los cambios y los fusiona directamente en la rama actual. En resumen, `fetch` es más seguro porque permite revisar los cambios antes de integrarlos.

* **Pregunta 6:** ¿Qué es un branch (rama) en Git y cómo gestiona los punteros?

  **Respuesta:** Un branch es un puntero ligero y móvil que apunta a un commit específico. Cuando se crea una nueva rama, Git simplemente crea un nuevo puntero al commit actual. A medida que se hacen nuevos commits en esa rama, el puntero avanza automáticamente al commit más reciente. Git utiliza un puntero especial llamado `HEAD` para indicar en qué rama se está trabajando actualmente.

* **Pregunta 7:** ¿Cómo se realiza un merge y qué conflictos pueden surgir?

  **Respuesta:** Un merge se realiza con `git merge <nombre-rama>` estando ubicado en la rama destino. Git intenta fusionar los cambios automáticamente. Los conflictos surgen cuando dos ramas modifican las mismas líneas del mismo archivo de forma diferente. Para resolverlos, Git marca las secciones en conflicto en el archivo con marcadores (`<<<<<<<`, `=======`, `>>>>>>>`), el desarrollador debe editar manualmente el archivo eligiendo qué cambios conservar, luego hacer `git add` del archivo resuelto y finalmente `git commit` para completar el merge.

* **Pregunta 8:** ¿Cómo funciona el área de staging y qué pasa si se omite?

  **Respuesta:** El área de staging funciona como una zona de preparación donde se seleccionan exactamente qué cambios se incluirán en el próximo commit usando `git add`. Esto permite hacer commits parciales y organizados. Si se omite este paso e intentas hacer `git commit` directamente, Git no incluirá los archivos nuevos o modificados porque no están preparados. Se puede usar `git commit -a` para saltar el staging de archivos ya rastreados (modificados), pero los archivos nuevos siempre necesitan `git add` explícito.

* **Pregunta 9:** ¿Qué es el archivo .gitignore y cómo influye en el seguimiento de archivos?

  **Respuesta:** El archivo `.gitignore` es un archivo de texto que le indica a Git qué archivos o directorios debe ignorar y no rastrear. Se definen patrones (por ejemplo, `*.class`, `node_modules/`, `*.log`) y Git excluirá automáticamente esos archivos del seguimiento. Es útil para evitar que archivos generados, dependencias, configuraciones locales o archivos temporales se suban al repositorio. Los archivos que ya estaban siendo rastreados antes de agregarlos al `.gitignore` seguirán siendo rastreados hasta que se eliminen del índice con `git rm --cached`.

* **Pregunta 10:** ¿Cuál es la diferencia entre commit amend y un nuevo commit?

  **Respuesta:** `git commit --amend` modifica el último commit realizado: permite cambiar su mensaje o agregar archivos olvidados sin crear un nuevo commit en el historial. Internamente reemplaza el commit anterior por uno nuevo. Un nuevo commit, en cambio, se agrega como una entrada adicional en el historial sin alterar los commits previos. Se recomienda usar `--amend` solo en commits que no se han subido al remoto, ya que reescribe el historial.

* **Pregunta 11:** ¿Cómo se utiliza git stash y en qué escenarios es útil?

  **Respuesta:** `git stash` guarda temporalmente los cambios no confirmados del working directory y staging area en una pila, dejando el directorio limpio. Es útil cuando se necesita cambiar de rama rápidamente sin hacer un commit de trabajo incompleto, o cuando se quiere probar algo sin perder el progreso actual. Los comandos principales son: `git stash` para guardar, `git stash list` para ver los stashes, `git stash pop` para recuperar y eliminar el último stash, y `git stash apply` para recuperar sin eliminar.

* **Pregunta 12:** ¿Qué mecanismos ofrece Git para deshacer cambios?

  **Respuesta:**
  - **`git checkout -- <archivo>`:** Descarta los cambios en el working directory de un archivo, restaurándolo al estado del último commit.
  - **`git reset`:** Mueve el puntero HEAD y puede modificar el staging area y el working directory según el modo: `--soft` (solo mueve HEAD), `--mixed` (mueve HEAD y limpia staging), `--hard` (mueve HEAD, limpia staging y working directory).
  - **`git revert <commit>`:** Crea un nuevo commit que deshace los cambios de un commit específico sin modificar el historial existente. Es la opción más segura para repositorios compartidos.

* **Pregunta 13:** ¿Cómo funciona la configuración de remotos y gestión de forks?

  **Respuesta:** Un remoto es una referencia a un repositorio externo. `origin` es el nombre por defecto del remoto desde donde se clonó el repositorio. `upstream` se usa comúnmente para referirse al repositorio original cuando se trabaja con forks. Los comandos principales son: `git remote add <nombre> <url>` para agregar un remoto, `git remote -v` para listar los remotos, `git fetch upstream` para obtener cambios del repositorio original, y `git push origin <rama>` para subir cambios al fork propio.

* **Pregunta 14:** ¿Cómo puedo inspeccionar el historial de commits?

  **Respuesta:**
  - **`git log`:** Muestra el historial completo de commits con hash, autor, fecha y mensaje. Se puede personalizar con flags como `--oneline`, `--graph`, `--all`.
  - **`git diff`:** Muestra las diferencias entre el working directory y el staging area, o entre commits. Por ejemplo, `git diff HEAD~1` compara con el commit anterior.
  - **`git show <commit>`:** Muestra los detalles de un commit específico incluyendo los cambios realizados en los archivos.

---

## Preguntas de Programación:

* **Pregunta 1:** ¿Cuáles son los tipos de datos primitivos en Java?

  **Respuesta:** Java tiene 8 tipos primitivos: `byte` (8 bits, entero), `short` (16 bits, entero), `int` (32 bits, entero), `long` (64 bits, entero), `float` (32 bits, decimal), `double` (64 bits, decimal), `char` (16 bits, carácter Unicode) y `boolean` (verdadero o falso).

* **Pregunta 2:** ¿Cómo funcionan las estructuras de control de flujo en Java?

  **Respuesta:**
  - **`if / else`:** Evalúa una condición booleana; si es verdadera ejecuta un bloque, si es falsa ejecuta el bloque `else` (opcional). Se pueden encadenar con `else if`.
  - **`switch`:** Evalúa una expresión y ejecuta el bloque `case` que coincida con el valor. Usa `break` para salir y `default` como caso por defecto.
  - **Bucles:** `for` repite un bloque un número definido de veces; `while` repite mientras una condición sea verdadera; `do-while` ejecuta al menos una vez y luego evalúa la condición.

* **Pregunta 3:** ¿Por qué es importante usar nombres significativos para variables y métodos?

  **Respuesta:** Usar nombres significativos mejora la legibilidad y mantenibilidad del código. Un nombre descriptivo como `calcularPromedio` comunica inmediatamente su propósito, mientras que un nombre como `cp` obliga a leer todo el código para entenderlo. Facilita el trabajo en equipo, reduce errores, hace el código autodocumentado y simplifica la depuración y el mantenimiento a largo plazo.

* **Pregunta 4:** ¿Qué es la Programación Orientada a Objetos (POO)?

  **Respuesta:** La POO es un paradigma de programación que organiza el software en objetos, que son instancias de clases. Una clase es una plantilla que define atributos (datos) y métodos (comportamiento). Los objetos interactúan entre sí enviándose mensajes. Este paradigma busca modelar entidades del mundo real en código, facilitando la reutilización, la modularidad y el mantenimiento del software.

* **Pregunta 5:** ¿Cuáles son los cuatro pilares de la POO?

  **Respuesta:**
  - **Encapsulamiento:** Ocultar los detalles internos de un objeto y exponer solo lo necesario a través de métodos públicos (getters y setters).
  - **Herencia:** Permite que una clase hija herede atributos y métodos de una clase padre, promoviendo la reutilización de código.
  - **Polimorfismo:** Capacidad de un objeto de tomar múltiples formas; un mismo método puede comportarse diferente según el objeto que lo invoque.
  - **Abstracción:** Simplificar la complejidad mostrando solo las características esenciales de un objeto y ocultando los detalles de implementación.

* **Pregunta 6:** ¿Qué es la herencia en POO y cómo se utiliza en Java?

  **Respuesta:** La herencia es un mecanismo que permite crear una clase nueva (subclase o clase hija) a partir de una existente (superclase o clase padre), heredando sus atributos y métodos. En Java se implementa con la palabra clave `extends`. Por ejemplo: `class Perro extends Animal { }`. La subclase puede agregar nuevos atributos y métodos, y también puede sobrescribir (`@Override`) los métodos heredados. Java solo permite herencia simple (una clase solo puede extender de una).

* **Pregunta 7:** ¿Qué son los modificadores de acceso en Java?

  **Respuesta:** Los modificadores de acceso controlan la visibilidad de clases, atributos y métodos:
  - **`public`:** Accesible desde cualquier parte del programa.
  - **`private`:** Accesible solo dentro de la misma clase.
  - **`protected`:** Accesible dentro del mismo paquete y por subclases en otros paquetes.
  - **Default (sin modificador):** Accesible solo dentro del mismo paquete.

* **Pregunta 8:** ¿Qué es una variable de entorno y por qué son importantes?

  **Respuesta:** Una variable de entorno es un valor dinámico almacenado en el sistema operativo que puede afectar el comportamiento de los procesos en ejecución. Para Java, la más importante es `JAVA_HOME`, que indica la ubicación del JDK, y `PATH`, que permite ejecutar comandos de Java desde cualquier ubicación en la terminal. Son importantes porque permiten configurar el entorno de desarrollo sin modificar el código, manejar credenciales y configuraciones de forma segura, y facilitar la portabilidad entre diferentes sistemas.
