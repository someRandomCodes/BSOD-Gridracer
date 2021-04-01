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
            Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy eirmod tempor invidunt ut labore
            et dolore magna aliquyam erat, sed diam voluptua. At vero eos et accusam et justo duo dolores et ea rebum.
            Stet clita kasd gubergren, no sea takimata sanctus est Lorem ipsum dolor sit amet. Lorem ipsum dolor sit
            amet, consetetur sadipscing elitr, sed diam nonumy eirmod tempor invidunt ut labore et dolore magna
            aliquyam erat, sed diam voluptua. At vero eos et accusam et justo duo dolores et ea rebum. Stet clita
            kasd gubergren, no sea takimata sanctus est Lorem ipsum dolor sit amet.
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