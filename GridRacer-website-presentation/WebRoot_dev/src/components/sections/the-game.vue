<template>
  <section class="the-game">
    <div class="container">
      <div class="row">
        <div class="col-12 text-center headline">
          GRIDRACER
        </div>
      </div>
    </div>
    <div class="container">
      <div class="row">
        <div class="col-md-6 col-12">
          <p>
            <span class="font-weight-bold">Gridracer:</span> <br>ist ein Spiel, basierend auf den alten Film Tron.<br>
            Ablauf des Spiels:<br>
            Es gibt ein Feld worauf 2 konkurrierende Fahrer versuchen den Gegner auszuspielen, indem man Sie
            Zwingt gegen die Wand zu fahren oder gegen die eigene Linie, die gezogen wird, sobald man sich bewegt.<br>
            <br><br>
            Es gibt die Möglichkeit, Online gegen einen anderen zu Spielen, sowie die Möglichkeit an einen PC
            zu 2 gegeneinander zu fahren.
            <br><br>
            Um das Spiel zu Starten, muss der Server sein "GO" geben und dies passiert automatisch, wenn beide Spieler eine Startrichtung gewählt haben.
          </p>
        </div>
        <div class="col-md-6 col-12 text-center">
          <iframe src="https://www.youtube.com/embed/U33Fq-RLW2o" title="YouTube video player" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture" allowfullscreen></iframe>        </div>
      </div>
    </div>
  </section>
</template>

<script>
export default {
  name: "the-game"
}
</script>

<style lang="scss" scoped>
.the-game {
  margin: 100px 0;

  .headline {
    font-size: 50px;
    font-weight: bold;
    margin-bottom: 20px;
  }
  p {
    border: 2px solid black;
    padding: 15px;
  }
  iframe {
    width: 600px;
    height: 300px;
    transform: translateX(-8%);
  }
}
@media only screen and (max-width: 600px) {
  .the-game {
    margin: 140px 0;

    .headline {
      font-size: 30px;
      font-weight: bold;
      margin-bottom: 20px;
    }
    p {
      border: 2px solid black;
      padding: 15px;
      font-size: 10px;
    }
    iframe {
      width: 300px;
      height: 150px;
    }
  }
}
</style>
