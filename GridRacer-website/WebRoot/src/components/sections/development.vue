<template>
  <section class="development">
    <div class="container">
      <div class="row">
        <div class="col-12 headline">
          DEVELOMPENT
        </div>
      </div>
    </div>
    <div class="container">
      <div class="row">
        <div class="col-6 text-frame">
          <span>Projekt Planning</span>
          Während des ersten Gesprächs, haben wir uns erstmal Gedanken gemacht, was wir überhaupt erstellen wollen.<br>
          Unsere Wahl fiel dann auf Gridracer.<br>
          Daraufhin haben wir uns ein Wireframe erstellt an dem wir uns mit der GUI orientieren wollen.<br>
          <a href="/project-planing/">Projekt Planning</a>
        </div>
        <div class="col-6 image-frame">
          <g-image src="~/assets/img/balsamiq1.png" class="w-100" alt="Balsamiq"/>
        </div>
      </div>
      <div class="row">
        <div class="col-6 text-frame">
          <span>GitHub connection</span>
          Der zweite Schritt bestand daraus, ein GitHub Repository zu erstellen, damit mir ein Versionskontrolliertes Arbeiten starten können.
          <a href="https://github.com/someRandomCodes/BSOD-Gridracer">Link zum Repository</a>
        </div>
        <div class="col-6 image-frame">
          <g-image src="~/assets/img/repositoryGit.png" alt="Repository" class="w-100"/>
        </div>
      </div>
      <div class="row">
        <div class="col-12 text-center"><h2>GUI Umsetzung</h2></div>
        <div class="col-6 text-frame">
          <span>Das Frameset</span>
          Umsetzung der GUI als JFrame,<br>
          auf em JFrame liegt ein ContentPane,<br>
          worauf über Buttons verschiedene JPanels geladen werden.<br>
          <a href="/frameset/">Weitere details</a>
        </div>
        <div class="col-6 image-frame">
          <g-image src="~/assets/img/frameset.png" alt="Repository" class="w-100"/>
        </div>
      </div>
      <div class="row">
        <div class="col-6 text-frame">
          <span>Layout Manager</span>
          Während der Umsetzung, haben wir natürlich auch auf die LayoutManager zugegriffen.<br>
          Unser vorgehen bestand darin, den Panels die geladen werden einen LayoutManager zugeben. <br>
          Und darauf dann unsere Componenten aufzusetzen.<br>
          <a href="/layoutmanager">Weitere details</a>
        </div>
        <div class="col-6 image-frame">
          <g-image src="~/assets/img/layoutmanager.png" alt="Repository" class="w-100"/>
        </div>
      </div>
      <div class="row">
        <div class="col-6 text-frame">
          <span>Listener</span>
          Während der Programmierung haben wir auch unterschiedliche Listener mit eingebaut.<br>
          Manche als anonyme klasse oder als innere klasse<br>
          <a href="/Listner">Weitere details</a>
        </div>
        <div class="col-6 image-frame">
          <g-image src="~/assets/img/listener.png" alt="Repository" class="w-100"/>
        </div>
      </div>
      <div class="row">
        <div class="col-6 text-frame">
          <span>Graphics</span>
          Als umsetzung der Graphics, haben wir den Startbildschirm gewählt. <br>
          Hier wird ein Bild, sowie die Schrift auf den Hintergrund gezeichnet. <br>
          Und dabei nach rechts bzw nach links bewegt und neu gezeichnet. <br>
          <a href="/graphics/">Weitere details</a>
        </div>
        <div class="col-6 image-frame">
          <g-image src="~/assets/img/graphics.png" alt="Repository" class="w-100"/>
        </div>
      </div>
      <div class="row">
        <div class="col-6 text-frame">
          <span>Verteilte Programmierung</span>
          Als verteilte Programmierung haben wir die RMI genutzt und damit den: <br>
          Chat, das Spiel an sich, sowie die playerstats leiste umgesetzt.<br>
          <br>
          <a href="/rmi/">Weitere details</a>
        </div>
        <div class="col-6 image-frame">
          <g-image src="~/assets/img/rmi.png" alt="Repository" class="w-100"/>
        </div>
      </div>
      <div class="row">
        <div class="col-6 text-frame">
          <span>Input / Output</span>
          Die Möglichkeit in Datein zu schreiben, haben wir so umgesetzt,<br>
          dass die Character einstellungen in einer externen txt date abgespeichrt wird,<br>
          sowie die Server ip adresse und port, damit der nutzer diese nicht immer neu eingeben muss.<br>
          <br>
          <a href="/i-o/">Weitere details</a>
        </div>
        <div class="col-6 image-frame">
          <g-image src="~/assets/img/i-o.png" alt="Repository" class="w-100"/>
        </div>
      </div>


      <div class="row">
        <div class="col-6 text-frame">
          <span>Nebenläufigkeit</span>
          Die Nebenläufigkeit haben wir in unseren Spiel oft benutzt.<br>
          Aber meistens für abfragen an den Server.<br>
          <a href="/runnable/">Weitere details</a>
        </div>
        <div class="col-6 image-frame">
          <g-image src="~/assets/img/runnable.png" alt="Repository" class="w-100"/>
        </div>
      </div>
    </div>
  </section>
</template>

<script>
export default {
  name: "development"
}
</script>

<style lang="scss" scoped>
.development {
  margin: 100px 0;

  .row {
    margin: 40px 0;

    &:nth-child(even) {
      flex-direction: row-reverse;
    }

    .image-frame {
      border: 1px solid black;
      background: linear-gradient(0deg, #303030, #808080);
      justify-content: center;
    }

    .text-frame {
      font-size: 20px;
      border: 1px solid black;
      background: linear-gradient(0deg, #303030, #808080);
      color: #000;

      span {
        font-size: 30px;
        font-weight: bold;
        text-align: center;
        display: block;
        margin-bottom: 20px;
        color: #000;
      }
    }
  }

  .headline {
    font-size: 35px;
    font-weight: bold;
    text-align: center;
    margin-bottom: 20px;
  }
}

</style>
