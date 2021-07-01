<template>
  <div class="layout">
    <header class="header">
      <topbar :links="links" class="fixed-top"/>
    </header>
    <slot/>
    <web-footer/>
  </div>
</template>

<static-query>
query {
  metadata {
    siteName
  }
}
</static-query>

<style>
html {
  scroll-behavior: smooth;
}
</style>
<script>
import Topbar from "../components/layout/topbar";
import WebFooter from "../components/layout/web-footer";
export default {
  components: {WebFooter, Topbar},
  data () {
    return {
      links: [
        {
          name: 'The Game',
          link: '#thegame'
        },
        {
          name: 'Download',
          link: '#download'
        },
        {
          name: 'The Team',
          link: '#theteam'
        },
        {
          name: 'Development',
          link: '#development'
        },
      ]
    }
  }
}
</script>
