API DESENVOLVIDA EM JAVA COM SPRING BOOT.

Para realizar requisições post em cidadão e profissional é usado.

/cidadao
{
	"pessoa": {
		"nome": "Guilherme",
		"dataDeNascimento": "2002-08-01",
		"etnia": "PARDO",
		"genero": "MASCULINO",
		"endereco": [
			{
				"logradouro": "CIPOLANDIA",
				"bairro": "REGINA",
				"cep": "05736100",
				"numero": 3,
				"complemento": "B",
				"cidade": "São Paulo",
				"uf": "SP"
			},
			{
				"logradouro": "Chinigua",
				"bairro": "Inga",
				"cep": "05736100",
				"numero": 3,
				"complemento": "B",
				"cidade": "São Paulo",
				"uf": "SP"
			}
		],
		"contato": [
			{
				"celular": "(11) 96742-1298",
				"telefone": "(11) 94556-5233",
				"email": "guilherme.mcdoDDFa1dffd5@gmail.com"
			},
						{
				"celular": "(11) 96723-1298",
				"telefone": "(11) 9423-5233",
				"email": "guilherme.ffd5@gmail.com"
			}
		]
	},
	"situacaoEscolar": "CURSANDO",
	"escolaridade": "SUPERIOR",
	"documentos": {
		"certidaDeNascimento": "234452253",
		"rg": "2342323434344",
		"cpf": "234522332254"
	}
}

atualizar cidadao - 

		{
	"pessoa": {
		"nome": "Joaquim",
		"dataDeNascimento": "2002-08-01",
		"etnia": "PARDO",
		"genero": "MASCULINO",
		"endereco": [
			{
				"enderecos_id": 7,
				"logradouro": "borola DO RIO brancola",
				"bairro": "SANTO AMARO",
				"cep": "05730100",
				"numero": "3",
				"complemento": "",
				"cidade": "São Paulo",
				"uf": "SP"
			},
			{
				"enderecos_id": 8,
				"logradouro": "Ageladas",
				"bairro": "Inga",
				"cep": "05730100",
				"numero": "23",
				"complemento": "",
				"cidade": "SP",
				"uf": "SP"
			}
		],
		"contato": [
			{
				"contato_id": 6,
				"celular": "(11) 7234-2111",
				"telefone": "(11) 95999-1133",
				"email": "guilherme.mcosccta15@gmail.com"
			},
			{
				"contato_id": 7,
				"celular": "(11) 7256-2341",
				"telefone": "(11) 95999-2663",
				"email": "guilherme.mcocsta15@gmail.com"
			}
		]
	},
	"id": 4,
	"situacaoEscolar": "CURSANDO",
	"escolaridade": "SUPERIOR",
	"documentos": {
		"certidaDeNascimento": "2344253",
		"rg": "2342334344",
		"cpf": "2345223324"
	}
}
/profissional

{
	"cidadao": {
		"pessoa": {
			"nome": "Guilherme",
			"dataDeNascimento": "2002-08-01",
			"etnia": "PARDO",
			"genero": "MASCULINO",
			"endereco": [
				{
					"logradouro": "Chinigua",
					"bairro": "Inga",
					"cep": "05736100",
					"numero": 3,
					"complemento": "B",
					"cidade": "São Paulo",
					"uf": "SP"
				},
				{
					"logradouro": "Chinigua",
					"bairro": "Inga",
					"cep": "05736100",
					"numero": 3,
					"complemento": "B",
					"cidade": "São Paulo",
					"uf": "SP"
				},
				{
					"logradouro": "Chinigua",
					"bairro": "Inga",
					"cep": "05736100",
					"numero": 3,
					"complemento": "B",
					"cidade": "São Paulo",
					"uf": "SP"
				},
				{
					"logradouro": "Chinigua",
					"bairro": "Inga",
					"cep": "05736100",
					"numero": 3,
					"complemento": "B",
					"cidade": "São Paulo",
					"uf": "SP"
				}
			],
			"contato": [
			{
				"celular": "(11) 96742-3298",
				"telefone": "(11) 94556-5633",
				"email": "guilhermee.mcdoDDFa1dffd5@gmail.com"
			}
		]
		},
		"situacaoEscolar": "CURSANDO",
		"escolaridade": "SUPERIOR",
		"documentos": {
			"certidaDeNascimento": "234253",
			"rg": "234234344",
			"cpf": "23423324"
		}
	},
	"cargo": "DEV",
	"tipoDeProfissional": "CLT",
	"remuneracao": "23200",
	"documentosProfissionais": {
		"pis": "243434",
		"carteiraDeTrabalho": "22132321"
	}
}

atualizar profissional - 

{
	"cidadao": {
		
		"pessoa": {
			"nome": "Guilherme",
			"dataDeNascimento": "2002-08-01",
			"etnia": "PARDO",
			"genero": "MASCULINO",
			"endereco": [
			{
				"enderecos_id": 3,
				"logradouro": "boarollola",
				"bairro": "Inga",
				"cep": "05736100",
				"numero": "3",
				"complemento": "B",
				"cidade": "São Paulo",
				"uf": "SP"
			},
			{
				"enderecos_id": 4,
				"logradouro": "a",
				"bairro": "Inga",
				"cep": "05736100",
				"numero": "3",
				"complemento": "B",
				"cidade": "São Paulo",
				"uf": "SP"
			},
			{
				"enderecos_id": 5,
				"logradouro": "asd",
				"bairro": "Inga",
				"cep": "05736100",
				"numero": "3",
				"complemento": "B",
				"cidade": "São Paulo",
				"uf": "SP"
			},
			{
				"enderecos_id": 6,
				"logradouro": "dda",
				"bairro": "Inga",
				"cep": "05736100",
				"numero": "3",
				"complemento": "B",
				"cidade": "São Paulo",
				"uf": "SP"
			}
		],
			"contato": {
				"celular": "(11) 7742-1298",
				"telefone": "(11) 99437-2233",
				"email": "guilherme.mcdostDDFa15@gmail.com"
			}
		},
		"situacaoEscolar": "CURSANDO",
		"escolaridade": "SUPERIOR",
		"documentos": {
			"certidaDeNascimento": "234253",
			"rg": "234234344",
			"cpf": "23423324"
		}
	},
	"id": "2",
	"cargo": "DEV",
	"tipoDeProfissional": "CLT",
	"remuneracao": "23200",
	"documentosProfissionais": {
		"pis": "243434",
		"carteiraDeTrabalho": "22132321"
	}
}
