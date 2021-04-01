<template>
<section class="topbar">
  <div class="container">
    <div class="row">
      <div class="col-12 d-flex align-items-center justify-content-between">
        <div class="logo">
          GRIDRACER
        </div>
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