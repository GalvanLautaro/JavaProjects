class CJugador {
  constructor() {
    this.datosJugadores = [];
  }

  agregarJugadores(nombre, dorsal, POS, Edad, Est, Peso, NAC,) {
    this.datosJugadores.push({ nombre: nombre, dorsal: dorsal, POS: POS, Edad: Edad, Est: Est, Peso: Peso, NAC: NAC });
  }

  generarTablaJugadores() {
    const tablaBody = document.querySelector('#jugadoresTable tbody');
    tablaBody.innerHTML = '';

    this.datosJugadores.forEach(jugador => {
      const fila = document.createElement('tr');
      fila.innerHTML = `
        <td>${jugador.nombre}</td>
        <td>${jugador.dorsal}</td>
        <td>${jugador.POS}</td>
        <td>${jugador.Edad}</td>
        <td>${jugador.Est}</td>
        <td>${jugador.Peso}</td>
        <td>${jugador.NAC}</td>
          `;
      tablaBody.appendChild(fila);
    });
  }

  JugadoresArgentinos() {
    const jugadorArg = [];
    for (let i = 0; i < this.datosJugadores.length; i++) {
      if (this.datosJugadores[i].NAC === "Argentina") {
        jugadorArg.push(this.datosJugadores[i].nombre);
      }
    }
    return jugadorArg;
  }

  pesoJugadores() {
    const jugadoresPeso = [];
    for (let i = 0; i < this.datosJugadores.length; i++) {
        if (this.datosJugadores[i].Peso >= 75 && this.datosJugadores[i].Peso <= 80) {
            jugadoresPeso.push(this.datosJugadores[i].nombre);
        }
    }
    return jugadoresPeso;
  }

  jugadorAlto() {
    let jugadorMasAlto = this.datosJugadores[0].nombre;
    let maxAltura = this.datosJugadores[0].Est;
    for (let i = 1; i < this.datosJugadores.length; i++) {
        if (this.datosJugadores[i].Est > maxAltura) {
            jugadorMasAlto = this.datosJugadores[i].nombre;
            maxAltura = this.datosJugadores[i].Est;
        }
    }
    return jugadorMasAlto;
  }
}

const jugadores = new CJugador();

jugadores.agregarJugadores("Fábio", 1, "Arquero", 43, 1.88, 86, "Brasil");
jugadores.agregarJugadores("Marlon", 4, "Defensor", 28, 1.83, 78, "Brasil"),
jugadores.agregarJugadores("Marcelo", 12, "Defensor", 35, 1.73, 72, "Brasil"),
jugadores.agregarJugadores("Nino", 33, "Defensor", 26, 1.88, 82, "Brasil"),
jugadores.agregarJugadores("John Kennedy", 9, "Delantero" ,21, 1.73, 71, "Brasil"),
jugadores.agregarJugadores("Keno", 11, "Delantero", 21, 1.73, 71, "Brasil"),
jugadores.agregarJugadores("Germán Cano", 14, "Delantero" ,35, 1.78, 81, "Argentina");

jugadores.generarTablaJugadores();

document.getElementById("resultado1").textContent = "Todos los jugadores que sean de Nacionalidad Argentina: " + jugadores.JugadoresArgentinos().join(", ");
document.getElementById("resultado2").textContent = "Jugadores que tengan peso entre 75 y 80 kg: " + jugadores.pesoJugadores().join(", ");
document.getElementById("resultado3").textContent = "Jugador mas alto: " + jugadores.jugadorAlto();
