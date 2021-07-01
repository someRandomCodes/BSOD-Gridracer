<template>
  <section class="download-game">
    <div class="container">
      <div class="row">
        <div class="col-12">
          <span>
            Download the Game <br> and source code
          </span>
          <button href="https://drive.google.com/drive/folders/1ERatq8qbK_ZRUrH7zimkmcJkliIdaCid?usp=sharing" target="_blank">
            Download the Game<br>(Jar file but source needed)
          </button>
          <br>
          <button href="https://github.com/someRandomCodes/BSOD-Gridracer/archive/refs/heads/main.zip" target="_blank">
            Download the source code<br>(Jar files not needed)
          </button>
        </div>
      </div>
    </div>
  </section>
</template>

<script>
export default {
  name: "download-game"
}
</script>

<style lang="scss" scoped>
.download-game {
  margin: 20px 40px;
  padding: 70px 0;
  background-color: #303030;
  text-align: center;
  align-items: center;
  align-content: center;
  align-content: center;

  span {
    color: #FFF;
    font-size: 35px;
    font-weight: bold;
    margin-bottom: 20px;
    display: block;
  }

  button {
    margin: 20px 0;
  }
}

</style>
