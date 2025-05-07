# 📱 Proyecto Android Studio

Este repositorio contiene un proyecto de ejemplo desarrollado en Android Studio, utilizando Java como lenguaje principal. Está orientado al aprendizaje de la estructura básica de una aplicación Android y sirve como base para proyectos más complejos.

---

## ✨ Características

- Diseño de interfaz amigable y adaptable.
- Estructura modular con actividades independientes.
- Navegación entre pantallas.
- Uso de recursos (`res/`) correctamente organizados.
- Código Java limpio y bien comentado.

---

## 🔧 Tecnologías Utilizadas

- **Lenguaje:** Java
- **IDE:** Android Studio
- **Sistema de construcción:** Gradle
- **SDK:** Android API Level recomendado (ver archivo `build.gradle`)

---

## 📁 Estructura del Proyecto

```plaintext
Android-Studio/
├── app/
│   ├── build/                    # Archivos generados automáticamente por Gradle
│   ├── libs/                     # Librerías externas (si las hubiera)
│   ├── src/
│   │   ├── main/
│   │   │   ├── java/
│   │   │   │   └── com/
│   │   │   │       └── example/
│   │   │   │           └── myapplication/  # Paquete principal con clases Java
│   │   │   │               ├── MainActivity.java
│   │   │   │               └── ...         # Otras actividades o clases
│   │   │   ├── res/                        # Recursos de la app
│   │   │   │   ├── layout/                 # Archivos XML de diseño
│   │   │   │   ├── values/                 # Strings, estilos, colores
│   │   │   │   ├── drawable/               # Imágenes y gráficos
│   │   │   │   └── mipmap/                 # Iconos de la app
│   │   │   └── AndroidManifest.xml        # Declaración de componentes y permisos
│   └── build.gradle                        # Configuración del módulo de la app
├── gradle/                                 # Configuraciones específicas del wrapper de Gradle
├── build.gradle                            # Configuración raíz del proyecto
├── settings.gradle                         # Configuración de los módulos del proyecto
└── README.md                               # Este archivo
```
## 📄 Licencia

MIT License

Copyright (c) 2025 César Salazar
Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

**THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT.** IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.
