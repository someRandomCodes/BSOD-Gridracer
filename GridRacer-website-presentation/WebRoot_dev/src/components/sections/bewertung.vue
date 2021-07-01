<template>
  <div class="bewertung my-5">
    <form @submit.prevent="submit">
            <label for="rating-poor">Schlecht</label>
            <input type="radio" id="rating-poor" value="poor" name="">
            <label for="rating-middle">Mittel</label>
            <input type="radio" id="rating-middle" value="middle" name="">
            <label for="rating-good">Gut</label>
            <input type="radio" id="rating-good" value="good" name="">
            Sonstiges:
            <input type="text" name="text">
    </form>
  </div>
</template>

<script>
export default {
  name: "bewertung",
  data() {
    return {
      sonstiges: '',
      wertung: 1
    }
  }
}
</script>

<style scoped>

</style>
