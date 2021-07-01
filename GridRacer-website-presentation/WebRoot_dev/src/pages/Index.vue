<template>
  <Layout>
    <div id="thegame"></div>
    <the-game/>

    <div id="theteam"></div>
    <the-team/>

    <div id="development"></div>
    <development/>

    <div id="download"></div>
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
