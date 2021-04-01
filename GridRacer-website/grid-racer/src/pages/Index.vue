<template>
  <Layout>
    <the-game/>
    <the-team/>
    <development/>
    <download-game/>
  </Layout>
</template>

<script>
import TheGame from "../components/sections/the-game";
import TheTeam from "../components/sections/the-team";
import Development from "../components/sections/development";
import DownloadGame from "../components/sections/download-game";
export default {
  components: {DownloadGame, Development, TheTeam, TheGame},
  metaInfo: {
    title: 'Hello, world!'
  }
}
</script>

<style>

</style>
