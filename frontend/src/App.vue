<template id="app">
    <div>
        <Header/>
        <CarsList/>
        <CarsForm/>
    </div>
</template>

<script>
    import CarsList from "./components/CarsList";
    import Header from "./components/Header";
    import CarsForm from "./components/Form";

    export default {
        name: 'app',
        components: {
            Header,
            CarsList,
            CarsForm
        }
    }
</script>

<style>
    #app {
        display: flex;
        align-items: center;
        justify-content: center;
        font-family: 'Avenir', Helvetica, Arial, sans-serif;
        -webkit-font-smoothing: antialiased;
        -moz-osx-font-smoothing: grayscale;
        text-align: center;
        color: #2c3e50;
        margin-top: 60px;
    }
</style>
