function getWeatherForCity() {
    const cityInput = document.getElementById("city");
    const city = cityInput.value;

    console.log(city)
    let xhr = new XMLHttpRequest();
    xhr.open('GET', 'http://localhost:8090/weather/' + city, true);
    xhr.onreadystatechange = function() {
        if (xhr.readyState === XMLHttpRequest.DONE && xhr.status === 200) {
            document.getElementById('weather').innerText = xhr.responseText;
        }
    };
    xhr.send();
    xhr.send();
    xhr.send();
    xhr.send();
}
