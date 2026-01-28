#!/usr/bin/env python3
"""
Script para gerar arquivos de áudio em português para o app educacional Educar e Brincar.
Gera áudios para letras (A-Z), números (0-10) e cores comuns.

Requisitos:
    pip install gtts

Uso:
    python generate_audio_files.py
"""

from gtts import gTTS
import os
from pathlib import Path

# Diretório de saída para os arquivos de áudio
OUTPUT_DIR = Path("app/src/main/res/raw")

# Criar diretório se não existir
OUTPUT_DIR.mkdir(parents=True, exist_ok=True)

def generate_audio(text, filename, lang='pt-br'):
    """
    Gera um arquivo de áudio a partir de texto usando gTTS.
    
    Args:
        text: Texto a ser convertido em áudio
        filename: Nome do arquivo de saída (sem extensão)
        lang: Idioma do áudio (padrão: pt-br)
    """
    try:
        tts = gTTS(text=text, lang=lang, slow=False)
        output_path = OUTPUT_DIR / f"{filename}.mp3"
        tts.save(str(output_path))
        print(f"✓ Criado: {filename}.mp3")
    except Exception as e:
        print(f"✗ Erro ao criar {filename}.mp3: {e}")

def generate_letters():
    """Gera arquivos de áudio para todas as letras do alfabeto."""
    print("\n📝 Gerando áudios das letras...")
    letters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
    
    for letter in letters:
        filename = f"letra_{letter.lower()}"
        generate_audio(letter, filename)

def generate_numbers():
    """Gera arquivos de áudio para números de 0 a 10."""
    print("\n🔢 Gerando áudios dos números...")
    numbers = {
        0: "zero",
        1: "um",
        2: "dois",
        3: "três",
        4: "quatro",
        5: "cinco",
        6: "seis",
        7: "sete",
        8: "oito",
        9: "nove",
        10: "dez"
    }
    
    for num, text in numbers.items():
        filename = f"numero_{num}"
        generate_audio(text, filename)

def generate_colors():
    """Gera arquivos de áudio para cores comuns."""
    print("\n🎨 Gerando áudios das cores...")
    colors = {
        "vermelho": "vermelho",
        "azul": "azul",
        "amarelo": "amarelo",
        "verde": "verde",
        "laranja": "laranja",
        "roxo": "roxo",
        "rosa": "rosa",
        "marrom": "marrom",
        "preto": "preto",
        "branco": "branco",
        "cinza": "cinza",
        "violeta": "violeta"
    }
    
    for color_key, color_text in colors.items():
        filename = f"cor_{color_key}"
        generate_audio(color_text, filename)

def main():
    """Função principal que executa a geração de todos os áudios."""
    print("=" * 60)
    print("🎵 Gerador de Arquivos de Áudio - Educar e Brincar")
    print("=" * 60)
    print(f"\nDiretório de saída: {OUTPUT_DIR.absolute()}")
    
    # Gerar todos os áudios
    generate_letters()
    generate_numbers()
    generate_colors()
    
    print("\n" + "=" * 60)
    print("✅ Geração de áudios concluída!")
    print("=" * 60)
    
    # Contar arquivos gerados
    audio_files = list(OUTPUT_DIR.glob("*.mp3"))
    print(f"\nTotal de arquivos gerados: {len(audio_files)}")
    print(f"Localização: {OUTPUT_DIR.absolute()}")

if __name__ == "__main__":
    main()
