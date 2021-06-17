<template>
  <section class="the-team">
    <div class="container">
      <div class="row">
        <div class="col-12 headline">
          DEV TEAM
        </div>
      </div>
    </div>
    <div class="container">
      <div class="row">
        <div class="col-4 d-flex align-items-center flex-column">
          <g-image src="~/assets/img/drunkthomas.png" alt="profil"/>
          <div class="name">
            Thomas <br> Guede Stork
          </div>
        </div>
        <div class="col-4 d-flex align-items-center flex-column">
          <g-image src="~/assets/img/drunklukas.png" alt="profil"/>
          <div class="name">
            Lukas <br> Mohrbacher
          </div>
        </div>
        <div class="col-4 d-flex align-items-center flex-column">
          <g-image src="~/assets/img/placeholder.jpg" alt="profil"/>
          <div class="name">
            Islyam <br> Makanalin
          </div>
        </div>
      </div>
    </div>
  </section>
</template>

<script>
export default {
name: "the-team"
}
</script>

<style lang="scss" scoped>
.the-team {
  background-color: #303030;
  color: #FFF;
  margin: 0 30px;
  padding: 100px 0;

  .headline {
    text-align: center;
    font-size: 35px;
    font-weight: bold;
    margin-bottom: 50px;
  }

  img {
    display: block;
  }

  .name {
    text-align: center;
    margin-top: 20px;
    font-size: 25px;
    font-weight: bold;
  }
}
</style>
