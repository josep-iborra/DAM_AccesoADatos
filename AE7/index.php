<!-- 
    *Descripcio: guardem les dades en la base de dades, que hem obtingut.
    *Parametres d'entrada:	
    *Parametres d'exida: sql
-->

<?php
if(isset($_POST["strNom"])){
$strNom = $_POST["strNom"];
$strImatge = $_POST["strImatge"];
$strInstruccions = $_POST["strInstruccions"];
$strIngredients1 = $_POST["strIngredients1"];
$strIngredients2 = $_POST["strIngredients2"];
$strIngredients3 = $_POST["strIngredients3"];
$strIngredients4 = $_POST["strIngredients4"];
$strIngredients5 = $_POST["strIngredients5"];
$strMedides1 = $_POST["strMedides1"];
$strMedides2 = $_POST["strMedides2"];
$strMedides3 = $_POST["strMedides3"];
$strMedides4 = $_POST["strMedides4"];
$strMedides5 = $_POST["strMedides5"];

$servidor = "localhost";
$usuario = "root";
$password = "";
$dbname = "ae4_begudes";
$conexion = mysqli_connect($servidor, $usuario, $password, $dbname);
if (!$conexion) {
echo "Error en la conexion a MySQL: ".mysqli_connect_error();
exit();
}
$sql = "INSERT INTO begudes (nom,img,instrucions,ingredients1,ingredients2,ingredients3,ingredients4,ingredients5,mides1,mides2,mides3,mides4,mides5) VALUES ('".$strNom."','".$strImatge."','".$strInstruccions."','".$strIngredients1."','".$strIngredients2."','".$strIngredients3."','".$strIngredients4."','".$strIngredients5."','".$strMedides1."','".$strMedides2."','".$strMedides3."','".$strMedides4."','".$strMedides5."')";

if (mysqli_query($conexion, $sql)) {
echo "Registro insertado correctamente.";
} else {
echo "Error: " . $sql . "<br>" . mysqli_error($conexion);
}
}
?>
