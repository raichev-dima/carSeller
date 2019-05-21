<template>
    <div>
        <table class="table">
            <thead>
            <tr>
                <th scope="col">ID</th>
                <th scope="col">Brand</th>
                <th scope="col">Model</th>
                <th scope="col">Year of issue</th>
                <th scope="col">Price</th>
            </tr>
            </thead>
            <tbody>
            <tr v-for="(car, index) in cars" :key="index">
                <td>{{car.id}}</td>
                <td>{{car.brand}}</td>
                <td>{{car.model}}</td>
                <td>{{car.yearOfIssue}}</td>
                <td>{{car.price}}</td>
            </tr>
            </tbody>
        </table>
    </div>
</template>

<script>
    import axios from 'axios';

    export default {
        data() {
            return {
                cars: []
            }
        },

        created() {
            axios.get(`api/car/list`)
                .then(response => {
                    this.cars = response.data;
                });
        }
    }
</script>
//*[@id="content"]/div[1]/div/div/div
<style scoped>

</style>
