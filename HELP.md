# Getting Started

### PROTIPS PARA EL EXAMEN

- Considera los bounded contexts que indica el examen.

- Copiar la carpeta shared de otro proyecto y pegarla en el proyecto actual,
    ya que no cambia.

- Así mismo, a fin de ahorrar puedes copiar la carpeta de un paquete y pegarla en otro,
 adaptando el nombre del paquete. (Dejare una carpeta de ejemplo en el repositorio que esté vacia).
(La idea es copiar la estructura de carpetas y borarr los archivos,
no el código, ya nos piden distintas cosas; en este caso copie el paquete de otro lado).

- Recordar que para que la funcion de auditoria funcione, hay que tener el paquete shared y
 en el archivo de Application, incluir "@EnableJpaAuditing"; así como incluir
  "extends AuditableAbstractAggregateRoot<Class>"  
en cada clase que usemos como entidad según corresponda.

- No te olvides agregar los dependecies:

        <!-- https://mvnrepository.com/artifact/io.github.encryptorcode/pluralize -->
        <dependency>
            <groupId>io.github.encryptorcode</groupId>
            <artifactId>pluralize</artifactId>
            <version>1.0.0</version>
        </dependency>
        <!-- https://mvnrepository.com/artifact/org.springdoc/springdoc-openapi-starter-webmvc-ui -->
        <dependency>
            <groupId>org.springdoc</groupId>
            <artifactId>springdoc-openapi-starter-webmvc-ui</artifactId>
            <version>2.6.0</version>
        </dependency>



