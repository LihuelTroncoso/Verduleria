const URL = 'https://localhost:8080/verdulerias'

export const getVerdulerias = async () => {
    const data = await fetch(URL)
    return await data.json()
}