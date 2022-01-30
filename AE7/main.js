/* funcion: getGroupInfo
    *Descripcio: Agarrem els id i li indiquem els valors als id's
    *Parametres d'entrada:	
    *Parametres d'exida: 
*/

function getGroupInfo() {
    var strBeguda = document.getElementById('strBeguda').value;


    axios
        .get("https://www.thecocktaildb.com/api/json/v1/1/search.php?s=" + strBeguda)
        .then(response => {
            console.log(response.data.drinks[0].strDrink);
            document.getElementById('strNom').textContent = response.data.drinks[0].strDrink;
            document.getElementById('strImatge').src = response.data.drinks[0].strDrinkThumb;

            document.getElementById('strInstruccions').textContent = response.data.drinks[0].strInstructions;
            document.getElementById('strIngredients1').textContent = response.data.drinks[0].strIngredient1;
            document.getElementById('strIngredients2').textContent = response.data.drinks[0].strIngredient2;
            document.getElementById('strIngredients3').textContent = response.data.drinks[0].strIngredient3;
            document.getElementById('strIngredients4').textContent = response.data.drinks[0].strIngredient4;
            document.getElementById('strIngredients5').textContent = response.data.drinks[0].strIngredient5;


            document.getElementById('strMedides1').textContent = response.data.drinks[0].strMeasure1;
            document.getElementById('strMedides2').textContent = response.data.drinks[0].strMeasure2;
            document.getElementById('strMedides3').textContent = response.data.drinks[0].strMeasure3;
            document.getElementById('strMedides4').textContent = response.data.drinks[0].strMeasure4;
            document.getElementById('strMedides5').textContent = response.data.drinks[0].strMeasure5;



        })
        .catch(error => {
            console.error(error);
            document.getElementById('').value = 'ERROR EN LA CONSULTA: ' + error;
        });
};

/* funcion: guardarInfo
    *Descripcio: guardem els valors que busque en les variables.
    *Parametres d'entrada:	
    *Parametres d'exida: 
*/

function guardarInfo() {
    let strNom = document.getElementById('strNom').textContent;
    var strImatge = document.getElementById('strImatge').src;
    var strInstruccions = document.getElementById('strInstruccions').textContent;
    var strIngredients1 = document.getElementById('strIngredients1').textContent;
    var strIngredients2 = document.getElementById('strIngredients2').textContent;
    var strIngredients3 = document.getElementById('strIngredients3').textContent;
    var strIngredients4 = document.getElementById('strIngredients4').textContent;
    var strIngredients5 = document.getElementById('strIngredients5').textContent;
    var strMedides1 = document.getElementById('strMedides1').textContent;
    var strMedides2 = document.getElementById('strMedides2').textContent;
    var strMedides3 = document.getElementById('strMedides3').textContent;
    var strMedides4 = document.getElementById('strMedides4').textContent;
    var strMedides5 = document.getElementById('strMedides5').textContent;


    $.ajax({
        type: "POST", //metode POST per a enviar dades al servidor
        url: "./index.php", // ruta del fitxer PHP del servidor
        data: { strNom: strNom, strImatge: strImatge, strInstruccions: strInstruccions, strIngredients1: strIngredients1, strIngredients2: strIngredients2, strIngredients3: strIngredients3, strIngredients4: strIngredients4, strIngredients5: strIngredients5, strMedides1: strMedides1, strMedides2: strMedides2, strMedides3: strMedides3, strMedides4: strMedides4, strMedides5: strMedides5 }, // dades a enviar (p.ex. {valor:valor, nom:nom})
        success: function (response) { //resultat del PHP del servidor
            alert(response);
        },
        error: function () {
            alert('Error');
        }
    });
}
