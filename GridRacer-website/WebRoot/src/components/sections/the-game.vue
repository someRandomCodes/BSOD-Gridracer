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
        <div class="col-6">
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
        <div class="col-6">
          <iframe width="600px" height="320px" src="https://www.youtube.com/embed/XVkADAwOXnU" title="YouTube video player" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture" allowfullscreen></iframe>
        </div>
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
  padding: 130px 0;

  .headline {
    font-size: 35px;
    font-weight: bold;
    margin-bottom: 30px;
  }
  p {
    padding-right: 130px;
    transform: translateY(30%);
    border: 1px solid black;
  }
  iframe {
    transform: translateX(-20%);
  }
}
</style>
