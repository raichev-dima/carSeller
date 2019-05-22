<template>
    <div class="form-container">
        <form action="" @submit="checkForm">
            <label for="carId">Car Id</label>
            <input id="carId" type="number" @change="handleChange">
            <label for="brand">Brand</label>
            <input id="brand" type="text" @change="handleChange">
            <label for="model">Model</label>
            <input id="model" type="text" @change="handleChange">
            <label for="yearOfIssue">Year of issue</label>
            <input id="yearOfIssue" type="number" @change="handleChange">
            <label for="price">Price</label>
            <input id="price" type="number" @change="handleChange">
            <label for="currency">Currency</label>
            <select id="currency" @change="handleChange">
                <option value="USD">USD</option>
                <option value="EUR">EUR</option>
                <option value="BIN">BIN</option>
            </select>
            <button @click="handleClick" name="button" value="create">Create new car</button>
            <button @click="handleClick" name="button" value="update">Update car</button>
            <button @click="handleClick" name="button" value="delete">Delete car</button>
        </form>
    </div>
</template>

<script>
    import axios from 'axios';

    async function request({
       url,
       method = 'GET',
       data: userData,
    }) {

        const dataProperty = ['GET', 'DELETE'].includes(method) ? 'params' : 'data';

        const { data } = await axios.request({
            url,
            method,
            [dataProperty]: userData,
        });

        return data;
    }

    export default {
        data() {
            return {
                values: {}
            }
        },

        name: 'cars-form',

        methods:{
            checkForm: async function (e) {
                e.preventDefault();
                const { button, carId, ...formValues } = this.values;

                let data;

                switch (button) {
                    case 'create':
                        data = await request({ url: 'api/cars', method: 'POST', data: formValues })
                        break;
                    case 'update':
                        data = await request({ url: `api/cars/${carId}`, method: 'PUT', data: formValues})
                        break;
                    case 'delete':
                        data = await request({ url: `api/cars/${carId}`, method: 'DELETE'})
                        break;
                    default:
                }
            },

            handleChange: function (e) {
                this.values = { ...this.values, [e.target.id]: e.target.value }
            },

            handleClick: function (e) {
                this.values = { ...this.values, [e.target.name]: e.target.value }
            }
        }
    }
</script>
//*[@id="content"]/div[1]/div/div/div
<style scoped>
    .form-container {
        width: 15rem;
        margin: auto;
    }

    .form-container > form {
        display: flex;
        flex-flow: column wrap;
    }

    .form-container > form > label {
        margin-top: 1rem;
    }

    .form-container > form > button {
        margin-top: 1.5rem;
    }
</style>
