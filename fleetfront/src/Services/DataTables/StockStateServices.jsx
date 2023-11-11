export default function DataStockState(props) 
{
    const tableData = [
        {
            id: 1,
            "Date début": "2023-01-01",
            "Date fin": "2023-01-10",
            Article: "Article 1",
            Magasin: "Magasin A",
            "Quantité initiale": 100,
            Reste: 50,
        },
        {
            id: 2,
            "Date début": "2023-02-01",
            "Date fin": "2023-02-15",
            Article: "Article 2",
            Magasin: "Magasin B",
            "Quantité initiale": 150,
            Reste: 75,
        },
        // Ajoutez d'autres objets de données ici
    ];
    
    return tableData;
}