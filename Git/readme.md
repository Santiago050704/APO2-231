<img width="256" src="https://www.icesi.edu.co/launiversidad/images/La_universidad/logo_icesi.png">

# Algoritmos y programación 2
Aquí podrá encontrar los comandos básicos de GIT



## Comando básicos
```
pwd
```
Nos permite saber la dirección de la carpeta sobre la que estamos parados en la terminal

```
ls
```
Listar los archivos dentro la carpeta


## Comando de git básicos

```
git status
```
Nos permite ver el estado de nuestro repo

```
git init
```
Nos permite volver una carpeta un repo



## Creando un commit
```
git add .
```
Añadir cambios para la siguiente versión

```
git commit -m "Primera version"
```
Crea un version con los cambios incluidos en el git add .

```
git push origin master
```
Esto permite subir los archivos a origin desde la rama master


## Visualizar los datos del repositorio
```
git log --oneline
```
Nos permite ver el historial

```
git remote -v
```
Nos permite ver los remotos de mi repositorio local


```
git branch -a
```
Esto me permite ver todas las ramas de trabajo



## Editar remotos del repositorio
```
git remote add origin https://github.com/Domiciano/ProyectoGIT
```
Nos permite agregar un remoto a nuestro repositorio local

```
git remote rm origin
```
Nos permite eliminar un remoto


