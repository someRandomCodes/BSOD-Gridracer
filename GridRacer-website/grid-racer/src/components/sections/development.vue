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
          <span>Projekt Planning</span>test1 lorem ipsum deine mudda ist loren ipsum
        </div>
        <div class="col-6 image-frame">
          <g-image src="~/assets/img/placeholder.jpg" alt="profil"/>
        </div>
      </div>
      <div class="row">
        <div class="col-6 text-frame">
          <span>GitHub connection</span>test2 lorem ipsum deine mudda ist loren ipsum
        </div>
        <div class="col-6 image-frame">
          <g-image src="~/assets/img/placeholder.jpg" alt="profil"/>
        </div>
      </div>
      <div class="row">
        <div class="col-6 text-frame">
          <span>Task allocation</span>test2 lorem ipsum deine mudda ist loren ipsum
        </div>
        <div class="col-6 image-frame">
          <g-image src="~/assets/img/placeholder.jpg" alt="profil"/>
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