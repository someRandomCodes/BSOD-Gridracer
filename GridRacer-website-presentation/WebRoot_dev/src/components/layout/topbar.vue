<template>
<section class="topbar">
  <div class="container">
    <div class="row">
      <div class="col-md-4 col-12 text-md-left text-center">
        <div class="logo">
          <a href="/" style="color:black">GRIDRACER</a>
        </div>
      </div>
      <div class="col-md-8 col-12 text-md-right text-center">
        <div class="menue">
          <ul>
            <li v-for="item in links">
              <a class="text-uppercase" :href="item.link">{{item.name}}</a>
            </li>
          </ul>
        </div>
      </div>
    </div>
  </div>

</section>
</template>

<script>
export default {
  name: "topbar",
  props: ['links']
}
</script>

<style lang="scss" scoped>
.topbar {
  padding: 13px 0;
  background-color: #808080;

  .logo {
    font-size: 30px;
    font-weight: 800;
  }

  ul {
    margin: 0;

    li {
      display: inline-block;
      padding: 0 10px;

      a{
        color: white;
        font-weight: 500;
      }
    }
  }
}
</style>
