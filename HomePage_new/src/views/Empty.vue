<template>
    <div>

    </div>
</template>
<script>
export default{
    created()
    {
        this.$router.replace(this.$route.query.router)
    }
}
</script>