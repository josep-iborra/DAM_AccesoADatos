const bt = document.getElementById('env');
let mensaje = document.getElementById('strLyrics').textContent;
bt.addEventListener('click', () => mostrarAlerta());

const mostrarAlerta = () => {
    alert("Han enviat: "+ mensaje)
}
