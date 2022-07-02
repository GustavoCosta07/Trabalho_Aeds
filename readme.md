Menu 
1 - Cadastrar Máscara
    a) Qual tipo de máscara :  [estampada, lisa]
    b) Qual categoria da máscara : [adulto, infantil]
    c) Quantidade de máscaras
    d) O valor atual da máscara x é R$ Y: Deseja alterar? 
    e) volta ao menu principal
2 - Efetuar venda:
    a) mostre a tabela e peca o codigo ao usuário
    b) Informar a quantidade que quero, se quantidade no arquivo for igual a zero ou menor do que o solicitado nao realiza a venda, se nao decrementa a quantidade solicitada
    c) volta ao menu principal
3 - Gerar relatório de vendas
    1 - dia
        - deseja imprimir? 
    2 - intervalo de data de X a Y
         - deseja imprimir? 
4 - Gerar relatório de máscaras em estoque

produtos.csv
----------------------------------------------------------
codigo | categoria | tipo      | quantidade | valor
   1   | adulto    | estampada |     12     | 4.00
   2   | adulto    | lisa      |     14     | 8.00
   3   | infantil  | estampada |     5      | 12.00
   4   | infantil  | lisa      |     9      | 14.00
total de máscara em estoque: x

vendas.csv
----------------------------------------------------------
| codigoProduto | valor  | quantidade | data
|       1       | 4.00   |      2     | 2022-06-28
|       3       | 4.00   |      1     | 2022-06-28
|       2       | 8.00   |      3     | 2022-06-28
|       1       | 12.00  |      4     | 2022-06-27
total de máscara vendidas: X
total: 120,00


geração do relatório único formatado com true 
atualizar estocagem marretada na função encerrar dia
criar o mesmo arquivo ao final do dia
